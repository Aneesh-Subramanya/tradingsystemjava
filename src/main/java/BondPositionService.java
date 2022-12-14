package main.java;

import java.util.List;

/**
 * Position Service to manage positions across multiple books and secruties.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class BondPositionService<T> extends PositionService<T> {
    // Add a trade to the service
    public void AddTrade(Trade<T> trade) {

    }

    @Override
    public Position<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Position<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<Position<T>> listener) {

    }

    @Override
    public List<ServiceListener<Position<T>>> GetListeners() {
        return null;
    }
}
