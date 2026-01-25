package decorator;

import strategy.TaxStrategy;

public class AppliedTax extends TaxDecorator {

    public AppliedTax(PriceComponent component, TaxStrategy taxStrategy) {
        super(component, taxStrategy);
    }

    @Override
    public double getTotalPrice() {
        double base = component.getTotalPrice();
        return base + taxStrategy.calculateTax(base);
    }
}
