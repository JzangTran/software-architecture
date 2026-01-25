package log;

import order.OrderState;

public abstract class OrderStateDecorator implements OrderState {
    protected OrderState wrappedState;

    public OrderStateDecorator(OrderState wrappedState) {
        this.wrappedState = wrappedState;
    }
}

