import decorator.BasePayment;
import decorator.DiscountDecorator;
import decorator.Payment;
import decorator.ProcessingFeeDecorator;
import context.PaymentContext;
import strategy.CreditCardPayment;
import strategy.PaymentStrategy;

public class Application {
    public static void main(String[] args) {
        Payment payment = new BasePayment(100);
        payment = new ProcessingFeeDecorator(payment);
        payment = new DiscountDecorator(payment);

        PaymentStrategy strategy = new CreditCardPayment();

        PaymentContext context = new PaymentContext();
        context.process(strategy, payment);
    }
}
