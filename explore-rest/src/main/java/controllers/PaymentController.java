package controllers;

import exception.NotEnoughMoneyException;
import models.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PaymentService;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(paymentService.processPayment());
        } catch (NotEnoughMoneyException e) {
            return ResponseEntity.badRequest()
                    .body(ErrorDetails.builder().message("Not enough money to make the payment.").build());
        }
    }
}
