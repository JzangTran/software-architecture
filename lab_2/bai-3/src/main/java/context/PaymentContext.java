package context;

import decorator.Payment;
import state.PaidState;
import state.PaymentState;
import state.UnpaidState;
import strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentState state;

    public PaymentContext() {
        this.state = new UnpaidState();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void process(PaymentStrategy strategy, Payment payment) {
        state.handlePayment(strategy, payment);
        setState(new PaidState());
    }
}
