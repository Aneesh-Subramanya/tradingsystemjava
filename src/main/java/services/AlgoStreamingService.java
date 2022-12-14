package main.java.services;

import main.enums.PricingSide;
import main.java.entities.AlgoStream;
import main.java.entities.Price;
import main.java.entities.PriceStream;
import main.java.entities.PriceStreamOrder;
import main.java.listeners.ServiceListener;
import main.java.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoStreamingService<T> extends Service<String, AlgoStream<T>> {
    private static long counter = 0;
    private final Map<String, AlgoStream<T>> algoStreamMap = new HashMap<>();
    private final List<ServiceListener<AlgoStream<T>>> listeners = new ArrayList<>();

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
