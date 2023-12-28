package client.openfeign.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import model.Payment;

@FeignClient(name ="payment",
                url="${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader  String requestId,
            @RequestBody Payment payment
    );
}
