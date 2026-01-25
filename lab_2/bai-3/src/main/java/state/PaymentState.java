package state;

import decorator.Payment;
import strategy.PaymentStrategy;

public interface PaymentState {
    void handlePayment(PaymentStrategy strategy, Payment payment);
}
