package decorator;

public class DiscountDecorator extends PaymentDecorator {

    public DiscountDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double getAmount() {
        return payment.getAmount() * 0.9; // giảm 10%
    }
}
