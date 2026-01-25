package state;

import decorator.Payment;
import strategy.PaymentStrategy;

public class PaidState implements PaymentState {

    @Override
    public void handlePayment(PaymentStrategy strategy, Payment payment) {
        System.out.println("Payment already processed");
    }
}
