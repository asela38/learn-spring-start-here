package aspects;

import exception.NotEnoughMoneyException;
import models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoney() {
        return ResponseEntity.badRequest()
                .body(ErrorDetails.builder().message("Not enough money to make the payment.").build());
    }
}
