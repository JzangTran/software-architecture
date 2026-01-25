package state;

import decorator.Payment;
import strategy.PaymentStrategy;

public class UnpaidState implements PaymentState {

    @Override
    public void handlePayment(PaymentStrategy strategy, Payment payment) {
        strategy.pay(payment.getAmount());
        System.out.println("Payment completed");
    }
}
