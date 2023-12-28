package server.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import model.Payment;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        log.info("Received request with ID {}; payment Amount: {}", requestId, payment.getAmount());
        return ResponseEntity.ok()
                .header("requestId", requestId)
                .body(payment.toBuilder().id(UUID.randomUUID().toString()).build());
    }
}
