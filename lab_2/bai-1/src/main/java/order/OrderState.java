package order;

public interface OrderState {
    public abstract void handle(OrderContext order);
}
