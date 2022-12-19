package main.java;

import java.util.List;
import java.util.Map;

/**
 * Market Data Service which distributes market data
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class MarketDataService<T> extends Service<String, OrderBook<T>> {
    private Map<String, OrderBook<T>> orderBookMap;
    private List<ServiceListener<OrderBook<T>>> listeners;

    public MarketDataService(Map<String, OrderBook<T>> orderBookMap, List<ServiceListener<OrderBook<T>>> listeners) {
        this.orderBookMap = orderBookMap;
        this.listeners = listeners;
    }

    public Map<String, OrderBook<T>> getOrderBookMap() {
        return orderBookMap;
    }

    public void setOrderBookMap(Map<String, OrderBook<T>> orderBookMap) {
        this.orderBookMap = orderBookMap;
    }

    public List<ServiceListener<OrderBook<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<OrderBook<T>>> listeners) {
        this.listeners = listeners;
    }

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
