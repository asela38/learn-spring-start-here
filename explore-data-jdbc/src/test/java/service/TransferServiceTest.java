package service;

import main.repository.AccountRepository;
import model.Account;
import model.AccountNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jdbc.repository.query.Modifying;

import javax.annotation.security.RunAs;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyPathFlow() {
        Account sender = Account.builder().id(1).amount(new BigDecimal(1000)).build();
        Account receiver = Account.builder().id(2).amount(new BigDecimal(1000)).build();

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transferMoney(1,2,new BigDecimal(100));

        then(accountRepository).should().changeAmount(1, new BigDecimal(900));

        then(accountRepository).should().changeAmount(2, new BigDecimal(1100));
    }

    @Test
    public void destinationAccountNotFoundFlow() {
        Account sender = Account.builder().id(1).amount(new BigDecimal(1000)).build();

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        Assertions.assertThrows(AccountNotFoundException.class,
                ()-> transferService.transferMoney(1,2,new BigDecimal(100)));

        then(accountRepository).should(never()).changeAmount(anyLong(), any());
    }
}
