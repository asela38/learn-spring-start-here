package service;

import model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender,
                              long idReceiver,
                              BigDecimal amount) {
        var sender = accountRepository.findAccountById(idSender);
        var receiver = accountRepository.findAccountById(idReceiver);

        var senderNewAmount = sender.getAmount().subtract(amount);
        var receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("Oh! no Something Went Wrong.");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
