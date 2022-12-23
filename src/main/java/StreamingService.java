package main.java;

import java.util.List;
import java.util.Map;

/**
 * Streaming service to publish two-way prices.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class StreamingService<T> extends Service<String, PriceStream<T>> {
    private Map<String, PriceStream<T>> streamMap;
    private List<ServiceListener<PriceStream<T>>> listeners;

    public StreamingService(Map<String, PriceStream<T>> streamMap, List<ServiceListener<PriceStream<T>>> listeners) {
        this.streamMap = streamMap;
        this.listeners = listeners;
    }

    public Map<String, PriceStream<T>> getStreamMap() {
        return streamMap;
    }

    public void setStreamMap(Map<String, PriceStream<T>> streamMap) {
        this.streamMap = streamMap;
    }

    public List<ServiceListener<PriceStream<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<PriceStream<T>>> listeners) {
        this.listeners = listeners;
    }

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
