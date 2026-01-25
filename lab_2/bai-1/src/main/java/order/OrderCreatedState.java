package order;

public class OrderCreatedState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Kiểm tra thông tin đơn hàng");
        order.setState(new ProcessingOrderState());
    }
}
