package controller;

import model.Account;
import model.TransferRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Account> getAllAccounts() {
        return tranferService.getAllAccounts();
    }
}
