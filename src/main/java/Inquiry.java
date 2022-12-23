package main.java;

import main.enums.InquiryState;
import main.enums.Side;

/**
 * Inquiry object modeling a customer inquiry from a client.
 * Type T is the product type.
 */
public class Inquiry<T> {
    private String inquiryId;
    private T product;
    private Side side;
    private long quantity;
    private Double price;
    private InquiryState state;

    public Inquiry(String inquiryId, T product, Side side, long quantity, Double price, InquiryState state) {
        this.inquiryId = inquiryId;
        this.product = product;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.state = state;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public InquiryState getState() {
        return state;
    }

    public void setState(InquiryState state) {
        this.state = state;
    }
}
