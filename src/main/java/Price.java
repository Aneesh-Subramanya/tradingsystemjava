package main.java;

import main.utils.UtilFunctions;

/**
 * A price object consisting of mid and bid/offer spread.
 * Type T is the product type.
 */
public class Price<T> {
    double mid;
    double bidOfferSpread;
    private T product;

    public Price(T product, double mid, double bidOfferSpread) {
        this.product = product;
        this.mid = mid;
        this.bidOfferSpread = bidOfferSpread;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getBidOfferSpread() {
        return bidOfferSpread;
    }

    public void setBidOfferSpread(double bidOfferSpread) {
        this.bidOfferSpread = bidOfferSpread;
    }

    @Override
    public String toString() {
        if (product instanceof Bond) {
            return "Price{" +
                    "product=" + ((Bond) product).getProductId() +
                    ", mid=" + mid +
                    ", bidOfferSpread=" + bidOfferSpread +
                    '}';
        }

        return "Price{" +
                "product=" + product +
                ", mid=" + UtilFunctions.convertToBondPrice(mid) +
                ", bidOfferSpread=" + UtilFunctions.convertToBondPrice(bidOfferSpread) +
                '}';
    }
}
