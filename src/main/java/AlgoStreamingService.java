package main.java;

import main.enums.PricingSide;

import java.util.List;
import java.util.Map;

public class AlgoStreamingService<T> extends Service<String, AlgoStream<T>> {
    private static long counter = 0;
    private Map<String, AlgoStream<T>> algoStreamMap;
    private List<ServiceListener<AlgoStream<T>>> listeners;

    public AlgoStreamingService(Map<String, AlgoStream<T>> algoStreamMap, List<ServiceListener<AlgoStream<T>>> listeners) {
        this.algoStreamMap = algoStreamMap;
        this.listeners = listeners;
    }

    public Map<String, AlgoStream<T>> getAlgoStreamMap() {
        return algoStreamMap;
    }

    public void setAlgoStreamMap(Map<String, AlgoStream<T>> algoStreamMap) {
        this.algoStreamMap = algoStreamMap;
    }

    public List<ServiceListener<AlgoStream<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<AlgoStream<T>>> listeners) {
        this.listeners = listeners;
    }

    public void addStream(Price<T> data) {
        T product = data.getProduct();
        if (product instanceof Product) {
            String productId = ((Product) product).getProductId();
            double mid = data.getMid();
            double bidOfferSpread = data.getBidOfferSpread();


            long visibleQuantity = counter % 2 == 0 ? 1000000 : 2000000;
            long hiddenQuantity = visibleQuantity * 2;
            counter++;

            PriceStreamOrder bidOrder = new PriceStreamOrder(mid - bidOfferSpread / 2, visibleQuantity, hiddenQuantity, PricingSide.BID);
            PriceStreamOrder offerOrder = new PriceStreamOrder(mid + bidOfferSpread / 2, visibleQuantity, hiddenQuantity, PricingSide.OFFER);

            PriceStream<T> priceStream = new PriceStream<>(product, bidOrder, offerOrder);
            AlgoStream<T> algoStream = new AlgoStream<>(priceStream);
            algoStreamMap.put(productId, algoStream);
            this.OnMessage(algoStream);
        }
    }

    @Override
    public AlgoStream<T> GetData(String key) {
        return algoStreamMap.get(key);
    }

    @Override
    public void OnMessage(AlgoStream<T> data) {
        for (ServiceListener<AlgoStream<T>> listener : listeners) {
            listener.ProcessAdd(data);
        }
    }

    @Override
    public void AddListener(ServiceListener<AlgoStream<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<AlgoStream<T>>> GetListeners() {
        return listeners;
    }
}
