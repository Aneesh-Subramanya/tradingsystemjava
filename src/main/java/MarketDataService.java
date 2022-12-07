package main.java;

import java.util.List;

/**
 * Market Data Service which distributes market data
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class MarketDataService<T> extends Service<String, OrderBook<T>> {


    // Get the best bid/offer order
    BidOffer GetBestBidOffer(String productId) {

        return null;
    }

    OrderBook<T> AggregateDepth(String productId) {

        return null;
    }

    @Override
    public OrderBook<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(OrderBook<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<OrderBook<T>> listener) {

    }

    @Override
    public List<ServiceListener<OrderBook<T>>> GetListeners() {
        return null;
    }
}
