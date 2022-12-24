package main.java.entities;

import main.constants.UtilConstants;
import main.java.products.Bond;

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

    public static Double GetPV01(String cusip) {
        switch (cusip) {
            case UtilConstants.UST2y:
                return 36.97;
            case UtilConstants.UST3y:
                return 40.63;
            case UtilConstants.UST5y:
                return 47.94;
            case UtilConstants.UST7y:
                return 59.38;
            case UtilConstants.UST10y:
                return 76.55;
            case UtilConstants.UST20y:
                return 144.85;
            case UtilConstants.UST30y:
                return 213.14;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        if (product instanceof Bond) {
            return "PV01{" +
                    "product=" + product +
                    ", pv01=" + pv01 +
                    ", quantity=" + quantity +
                    '}';
        }
        return "PV01{" +
                "product=" + product +
                ", pv01=" + pv01 +
                ", quantity=" + quantity +
                '}';
    }
}
