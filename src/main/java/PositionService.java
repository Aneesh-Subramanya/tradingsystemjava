package main.java;

import java.util.List;

/**
 * Position Service to manage positions across multiple books and secruties.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class PositionService<T> extends Service<String, Position<T>> {
    // Add a trade to the service
    public abstract void AddTrade(Trade<T> trade);
}
