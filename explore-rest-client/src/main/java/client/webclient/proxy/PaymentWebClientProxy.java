package client.webclient.proxy;

import model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentWebClientProxy {
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String uri;

    public PaymentWebClientProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(
            String requestId,
            Payment payment) {

        return webClient.post()
                .uri(uri + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);


    }
}
