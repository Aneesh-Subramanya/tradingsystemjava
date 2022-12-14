package main.java;

import java.util.List;

/**
 * Market Data Service which distributes market data
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class MarketDataService<T> extends Service<String, OrderBook<T>> {
    // Get the best bid/offer order
    public abstract BidOffer GetBestBidOffer(String productId);

    // Aggregate the order book
    public abstract OrderBook<T> AggregateDepth(String productId);
}
