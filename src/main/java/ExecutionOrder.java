package main.java;

import main.enums.OrderType;
import main.enums.PricingSide;

/**
 * An execution order that can be placed on an exchange.
 * Type T is the product type.
 */
public class ExecutionOrder<T> {
    private T product;
    private PricingSide side;
    private String orderId;
    private OrderType orderType;
    private double price;
    private double visibleQuantity;
    private double hiddenQuantity;
    private String parentOrderId;
    private boolean isChildOrder;

    public ExecutionOrder(T product, PricingSide side, String orderId, OrderType orderType, double price, double visibleQuantity, double hiddenQuantity, String parentOrderId, boolean isChildOrder) {
        this.product = product;
        this.side = side;
        this.orderId = orderId;
        this.orderType = orderType;
        this.price = price;
        this.visibleQuantity = visibleQuantity;
        this.hiddenQuantity = hiddenQuantity;
        this.parentOrderId = parentOrderId;
        this.isChildOrder = isChildOrder;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public PricingSide getSide() {
        return side;
    }

    public void setSide(PricingSide side) {
        this.side = side;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVisibleQuantity() {
        return visibleQuantity;
    }

    public void setVisibleQuantity(double visibleQuantity) {
        this.visibleQuantity = visibleQuantity;
    }

    public double getHiddenQuantity() {
        return hiddenQuantity;
    }

    public void setHiddenQuantity(double hiddenQuantity) {
        this.hiddenQuantity = hiddenQuantity;
    }

    public String getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(String parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public boolean isChildOrder() {
        return isChildOrder;
    }

    public void setChildOrder(boolean childOrder) {
        isChildOrder = childOrder;
    }
}
