package main.java;

/**
 * PV01 risk.
 * Type T is the product type.
 */
public class PV01<T> {
    private T product;
    private double pv01;
    private long quantity;

    public PV01(T product, double pv01, long quantity) {
        this.product = product;
        this.pv01 = pv01;
        this.quantity = quantity;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public double getPv01() {
        return pv01;
    }

    public void setPv01(double pv01) {
        this.pv01 = pv01;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
