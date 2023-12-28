package client.resttemplate.controllers;

import client.resttemplate.proxy.PaymentRestTemplateProxy;
import model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentRestTemplateProxy proxy;

    @Autowired
    public PaymentsController(PaymentRestTemplateProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
            ) {
        return proxy.createPayment(payment);
    }
}
