package client.resttemplate.proxy;

import model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentRestTemplateProxy {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    public PaymentRestTemplateProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        String uri = paymentsServiceUrl + "/payment";

        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<Payment>( payment, headers), Payment.class).getBody();
    }
}
