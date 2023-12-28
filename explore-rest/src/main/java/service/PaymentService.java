package service;

import exception.NotEnoughMoneyException;
import models.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetail processPayment() {
        throw new NotEnoughMoneyException();
    }
}
