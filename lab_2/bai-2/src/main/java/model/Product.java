package model;

import decorator.BasePrice;
import decorator.PriceComponent;
import state.ProductState;

public class Product {
    private ProductState state;
    private double basePrice;

    public Product(double basePrice, ProductState state) {
        this.basePrice = basePrice;
        this.state = state;
    }

    public void changeState(ProductState state) {
        this.state = state;
    }

    public double getFinalPrice() {
        PriceComponent base = new BasePrice(basePrice);
        return state.applyTaxes(base).getTotalPrice();
    }
}
