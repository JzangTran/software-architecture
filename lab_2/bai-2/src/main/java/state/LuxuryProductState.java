package state;

import decorator.AppliedTax;
import decorator.PriceComponent;
import strategy.LuxuryTax;
import strategy.VATTax;

public class LuxuryProductState implements ProductState {

    @Override
    public PriceComponent applyTaxes(PriceComponent basePrice) {
        PriceComponent price = new AppliedTax(basePrice, new VATTax());
        price = new AppliedTax(price, new LuxuryTax());
        return price;
    }
}
