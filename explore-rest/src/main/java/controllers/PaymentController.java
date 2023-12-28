package controllers;

import exception.NotEnoughMoneyException;
import lombok.extern.slf4j.Slf4j;
import models.ErrorDetails;
import models.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.PaymentService;

@RestController
@Slf4j
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentService.processPayment());
    }

    @PostMapping("/payment2")
    public ResponseEntity<?> makePayment2(
            @RequestBody PaymentDetail paymentDetail
            ) {
        log.info("Receive Payment : {}", paymentDetail.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentDetail);
    }
}
