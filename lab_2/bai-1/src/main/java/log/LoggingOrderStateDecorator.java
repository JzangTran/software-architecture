package log;

import order.OrderContext;
import order.OrderState;

public class LoggingOrderStateDecorator extends OrderStateDecorator {

    public LoggingOrderStateDecorator(OrderState wrappedState) {
        super(wrappedState);
    }

    @Override
    public void handle(OrderContext order) {
        System.out.println("[LOG] Start state: " + wrappedState.getClass().getSimpleName());
        wrappedState.handle(order);
        System.out.println("[LOG] End state");
    }
}

