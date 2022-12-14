package main.java;

import java.util.List;

/**
 * Pricing Service managing mid prices and bid/offers.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class BondPricingService<T> extends PricingService<T> {
    @Override
    public Price<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Price<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<Price<T>> listener) {

    }

    @Override
    public List<ServiceListener<Price<T>>> GetListeners() {
        return null;
    }
}
