import bank.BankTransferRefund;
import log.LoggingOrderStateDecorator;
import order.CancelledOrderState;
import order.OrderContext;
import order.OrderCreatedState;

public class Application {
    public static void main(String[] args) {
        OrderContext order = new OrderContext(
                new LoggingOrderStateDecorator(new OrderCreatedState())
        );

        order.process();
        order.process();

        OrderContext cancelledOrder = new OrderContext(
                new LoggingOrderStateDecorator(
                        new CancelledOrderState(new BankTransferRefund())
                )
        );

        cancelledOrder.process();
    }
}
