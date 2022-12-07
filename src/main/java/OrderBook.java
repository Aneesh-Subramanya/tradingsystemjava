package main.java;

import java.util.List;

/**
 * Order book with a bid and offer stack.
 * Type T is the product type.
 */
public class OrderBook<T> {
    T product;
    List<Order> bidStack;
    List<Order> offerStack;

    public OrderBook(T product, List<Order> bidStack, List<Order> offerStack) {
        this.product = product;
        this.bidStack = bidStack;
        this.offerStack = offerStack;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public List<Order> getBidStack() {
        return bidStack;
    }

    public void setBidStack(List<Order> bidStack) {
        this.bidStack = bidStack;
    }

    public List<Order> getOfferStack() {
        return offerStack;
    }

    public void setOfferStack(List<Order> offerStack) {
        this.offerStack = offerStack;
    }
}
