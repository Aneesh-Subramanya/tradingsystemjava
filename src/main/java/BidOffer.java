package main.java;

/**
 * Class representing a bid and offer order
 */
public class BidOffer {
    private Order bidOrder;
    private Order offerOrder;

    public BidOffer(Order bidOrder, Order offerOrder) {
        this.bidOrder = bidOrder;
        this.offerOrder = offerOrder;
    }

    public Order getBidOrder() {
        return bidOrder;
    }

    public void setBidOrder(Order bidOrder) {
        this.bidOrder = bidOrder;
    }

    public Order getOfferOrder() {
        return offerOrder;
    }

    public void setOfferOrder(Order offerOrder) {
        this.offerOrder = offerOrder;
    }
}
