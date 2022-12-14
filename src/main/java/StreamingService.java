package main.java;

/**
 * Streaming service to publish two-way prices.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class StreamingService<T> extends Service<String, PriceStream<T>> {
    // Publish two-way prices
    public void PublishPrice(PriceStream<T> priceStream) {

    }
}
