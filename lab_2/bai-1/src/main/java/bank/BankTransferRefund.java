package bank;

public class BankTransferRefund implements RefundStrategy {
    @Override
    public void refund() {
        System.out.println("Hoàn tiền qua chuyển khoản ngân hàng");
    }
}

