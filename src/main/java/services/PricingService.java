package main.java.services;

import main.java.entities.Price;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pricing Service managing mid prices and bid/offers.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class PricingService<T> extends Service<String, Price<T>> {

    private final Map<String, Price<T>> priceMap = new HashMap<>();
    private final List<ServiceListener<Price<T>>> listeners = new ArrayList<>();

    @Override
    public Price<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Price<T> data) {
        T product = data.getProduct();
        if (product instanceof Bond) {
            String productId = ((Bond) product).getProductId();
            priceMap.put(productId, data);
            for (ServiceListener<Price<T>> listener : listeners) {
                listener.ProcessAdd(data);
            }
        }
    }

    @Override
    public void AddListener(ServiceListener<Price<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<Price<T>>> GetListeners() {
        return listeners;
    }
}
