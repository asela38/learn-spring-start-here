package controller;

import model.Account;
import model.TransferRequest;
import org.springframework.web.bind.annotation.*;
import service.TransferService;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService tranferService;

    public AccountController(TransferService tranferService) {
        this.tranferService = tranferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
            ) {
        tranferService.transferMoney(transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(), transferRequest.getAmount());
    }


    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if(name == null)
            return tranferService.getAllAccounts();
        return tranferService.findAccountByName(name);
    }
}
