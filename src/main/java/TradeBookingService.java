package main.java;

import java.util.List;

/**
 * Trade Booking Service to book trades to a particular book.
 * Keyed on trade id.
 * Type T is the product type.
 */
public class TradeBookingService<T> extends Service<String, Trade<T>> {
    // Book the trade
    void BookTrade(Trade<T> trade) {

    }

    @Override
    public Trade<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Trade<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<Trade<T>> listener) {

    }

    @Override
    public List<ServiceListener<Trade<T>>> GetListeners() {
        return null;
    }
}
