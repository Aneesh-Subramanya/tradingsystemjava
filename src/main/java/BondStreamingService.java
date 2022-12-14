package main.java;

import java.util.List;

/**
 * Streaming service to publish two-way prices.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class BondStreamingService<T> extends StreamingService<T> {
    // Publish two-way prices
    public void PublishPrice(PriceStream<T> priceStream) {

    }

    @Override
    public PriceStream<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(PriceStream<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<PriceStream<T>> listener) {

    }

    @Override
    public List<ServiceListener<PriceStream<T>>> GetListeners() {
        return null;
    }
}
