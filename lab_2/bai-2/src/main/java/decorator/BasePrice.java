package decorator;

public class BasePrice implements PriceComponent {
    private final double price;

    public BasePrice(double price) {
        this.price = price;
    }

    @Override
    public double getTotalPrice() {
        return price;
    }
}
