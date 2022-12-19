package main.java;

import java.util.List;
import java.util.Map;

/**
 * Trade Booking Service to book trades to a particular book.
 * Keyed on trade id.
 * Type T is the product type.
 */
public class TradeBookingService<T> extends Service<String, Trade<T>> {
    private Map<String, Trade<T>> tradeMap;
    private List<ServiceListener<Trade<T>>> listeners;

    public TradeBookingService(Map<String, Trade<T>> tradeMap, List<ServiceListener<Trade<T>>> listeners) {
        this.tradeMap = tradeMap;
        this.listeners = listeners;
    }

    public Map<String, Trade<T>> getTradeMap() {
        return tradeMap;
    }

    public void setTradeMap(Map<String, Trade<T>> tradeMap) {
        this.tradeMap = tradeMap;
    }

    public List<ServiceListener<Trade<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<Trade<T>>> listeners) {
        this.listeners = listeners;
    }

    // Book the trade
    void BookTrade(Trade<T> trade) {
        tradeMap.put(trade.getTradeId(), trade);
        for (ServiceListener<Trade<T>> listener : listeners) {
            listener.ProcessAdd(trade);
        }
    }

    @Override
    public Trade<T> GetData(String key) {
        return tradeMap.get(key);
    }

    @Override
    public void OnMessage(Trade<T> data) {
        BookTrade(data);
    }

    @Override
    public void AddListener(ServiceListener<Trade<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<Trade<T>>> GetListeners() {
        return listeners;
    }
}
