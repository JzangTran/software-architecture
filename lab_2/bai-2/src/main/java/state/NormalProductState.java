package state;

import decorator.AppliedTax;
import decorator.PriceComponent;
import strategy.VATTax;

public class NormalProductState implements ProductState {

    @Override
    public PriceComponent applyTaxes(PriceComponent basePrice) {
        return new AppliedTax(basePrice, new VATTax());
    }
}
