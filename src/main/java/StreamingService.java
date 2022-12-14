package main.java;

import java.util.List;

/**
 * Streaming service to publish two-way prices.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class StreamingService<T> extends Service<String, Position<T>> {

    // Publish two-way prices
    void PublishPrice(PriceStream<T> priceStream) {

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
