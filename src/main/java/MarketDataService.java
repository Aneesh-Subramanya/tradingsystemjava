package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Market Data Service which distributes market data
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class MarketDataService<T> extends Service<String, OrderBook<T>> {
    private final Map<String, OrderBook<T>> orderBookMap = new HashMap<>();
    private final List<ServiceListener<OrderBook<T>>> listeners = new ArrayList<>();


    // Get the best bid/offer order
    BidOffer GetBestBidOffer(String productId) {
        return orderBookMap.get(productId).GetBidOffer();
    }

    OrderBook<T> AggregateDepth(String productId) {
        return orderBookMap.get(productId);
    }

    @Override
    public OrderBook<T> GetData(String key) {
        return orderBookMap.get(key);
    }

    @Override
    public void OnMessage(OrderBook<T> data) {
        T product = data.getProduct();
        if (product instanceof Product) {
            orderBookMap.put(((Product) product).getProductId(), data);
            for (ServiceListener<OrderBook<T>> listener : listeners) {
                listener.ProcessAdd(data);
            }
        }
    }

    @Override
    public void AddListener(ServiceListener<OrderBook<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<OrderBook<T>>> GetListeners() {
        return listeners;
    }
}
