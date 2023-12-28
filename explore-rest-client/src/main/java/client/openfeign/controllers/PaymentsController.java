package client.openfeign.controllers;

import client.openfeign.proxies.PaymentProxy;
import lombok.extern.slf4j.Slf4j;
import model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentsController {
    private final PaymentProxy paymentProxy;

    @Autowired
    public PaymentsController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentProxy.createPayment(UUID.randomUUID().toString(), payment);
    }
}
