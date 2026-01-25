package order;

import bank.RefundStrategy;

public class CancelledOrderState implements OrderState {
    private RefundStrategy refundStrategy;

    public CancelledOrderState(RefundStrategy refundStrategy) {
        this.refundStrategy = refundStrategy;
    }

    @Override
    public void handle(OrderContext order) {
        System.out.println("Hủy đơn hàng");
        refundStrategy.refund();
    }
}

