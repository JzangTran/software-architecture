package decorator;

import strategy.TaxStrategy;

public abstract class TaxDecorator implements PriceComponent {
    protected PriceComponent component;
    protected TaxStrategy taxStrategy;

    public TaxDecorator(PriceComponent component, TaxStrategy taxStrategy) {
        this.component = component;
        this.taxStrategy = taxStrategy;
    }
}
