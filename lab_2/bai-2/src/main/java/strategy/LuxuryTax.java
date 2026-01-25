package strategy;

public class LuxuryTax implements TaxStrategy {
    @Override
    public double calculateTax(double basePrice) {
        return basePrice * 0.20; // 20%
    }
}
