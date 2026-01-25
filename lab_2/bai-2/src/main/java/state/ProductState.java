package state;

import decorator.PriceComponent;

public interface ProductState {
    PriceComponent applyTaxes(PriceComponent basePrice);
}
