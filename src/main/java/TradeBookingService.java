package main.java;

import java.util.List;

/**
 * Trade Booking Service to book trades to a particular book.
 * Keyed on trade id.
 * Type T is the product type.
 */
public abstract class TradeBookingService<T> extends Service<String, Trade<T>> {
    // Book the trade
    public abstract void BookTrade(Trade<T> trade);
}
