package strategy;

public class VATTax implements TaxStrategy {
    @Override
    public double calculateTax(double basePrice) {
        return basePrice * 0.10;
    }
}
