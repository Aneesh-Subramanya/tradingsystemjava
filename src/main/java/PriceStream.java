package main.java;

/**
 * Price Stream with a two-way market.
 * Type T is the product type.
 */
public class PriceStream<T> {
    T product;
    PriceStreamOrder bidOrder;
    PriceStreamOrder offerOrder;

    public PriceStream(T product, PriceStreamOrder bidOrder, PriceStreamOrder offerOrder) {
        this.product = product;
        this.bidOrder = bidOrder;
        this.offerOrder = offerOrder;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public PriceStreamOrder getBidOrder() {
        return bidOrder;
    }

    public void setBidOrder(PriceStreamOrder bidOrder) {
        this.bidOrder = bidOrder;
    }

    public PriceStreamOrder getOfferOrder() {
        return offerOrder;
    }

    public void setOfferOrder(PriceStreamOrder offerOrder) {
        this.offerOrder = offerOrder;
    }

    @Override
    public String toString() {
        if (product instanceof Bond) {
            return "PriceStream{" +
                    "productId=" + ((Bond) product).getProductId() +
                    ", bidOrder=" + bidOrder +
                    ", offerOrder=" + offerOrder +
                    '}';
        }
        return "PriceStream{" +
                "product=" + product +
                ", bidOrder=" + bidOrder +
                ", offerOrder=" + offerOrder +
                '}';
    }
}
