package client.webclient.controllers;

import client.webclient.proxy.PaymentWebClientProxy;
import model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentsReactiveController {
    private final PaymentWebClientProxy proxy;

    public PaymentsReactiveController(PaymentWebClientProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(
            @RequestBody Payment payment
    ) {
        return proxy.createPayment(UUID.randomUUID().toString(),payment);
    }
}
