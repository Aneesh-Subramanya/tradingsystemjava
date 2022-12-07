package main.java;

import main.enums.PricingSide;

/**
 * A market data order with price, quantity, and side.
 */
public class Order {
    private double price;
    private long quantity;
    private PricingSide side;

    public Order(double price, long quantity, PricingSide side) {
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public PricingSide getSide() {
        return side;
    }

    public void setSide(PricingSide side) {
        this.side = side;
    }
}
