package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Streaming service to publish two-way prices.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class StreamingService<T> extends Service<String, PriceStream<T>> {
    private final Map<String, PriceStream<T>> streamMap = new HashMap<>();
    private final List<ServiceListener<PriceStream<T>>> listeners = new ArrayList<>();


    // Publish two-way prices
    void PublishPrice(PriceStream<T> data) {
        T product = data.getProduct();
        if (product instanceof Product) {
            String productId = ((Product) product).getProductId();
            this.streamMap.put(productId, data);
            this.OnMessage(data);
        }
    }

    @Override
    public PriceStream<T> GetData(String key) {
        return streamMap.get(key);
    }

    @Override
    public void OnMessage(PriceStream<T> data) {
        for (ServiceListener<PriceStream<T>> listener : listeners) {
            listener.ProcessAdd(data);
        }
    }

    @Override
    public void AddListener(ServiceListener<PriceStream<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<PriceStream<T>>> GetListeners() {
        return listeners;
    }
}
