package strategy;

public class ConsumptionTax implements TaxStrategy {
    @Override
    public double calculateTax(double basePrice) {
        return basePrice * 0.05;
    }
}
