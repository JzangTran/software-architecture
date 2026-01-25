package order;

public class DeliveredOrderState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Đã giao");
    }
}
