package main.java;

import main.enums.PricingSide;

/**
 * A price stream order with price and quantity (visible and hidden)
 */
public class PriceStreamOrder {
    double price;
    long visibleQuantity;
    long hiddenQuantity;
    PricingSide side;

    public PriceStreamOrder(double price, long visibleQuantity, long hiddenQuantity, PricingSide side) {
        this.price = price;
        this.visibleQuantity = visibleQuantity;
        this.hiddenQuantity = hiddenQuantity;
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getVisibleQuantity() {
        return visibleQuantity;
    }

    public void setVisibleQuantity(long visibleQuantity) {
        this.visibleQuantity = visibleQuantity;
    }

    public long getHiddenQuantity() {
        return hiddenQuantity;
    }

    public void setHiddenQuantity(long hiddenQuantity) {
        this.hiddenQuantity = hiddenQuantity;
    }

    public PricingSide getSide() {
        return side;
    }

    public void setSide(PricingSide side) {
        this.side = side;
    }
}
