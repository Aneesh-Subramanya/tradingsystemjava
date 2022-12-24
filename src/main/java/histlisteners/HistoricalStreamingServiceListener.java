package main.java.histlisteners;

import main.java.entities.PriceStream;
import main.java.histservices.HistoricalStreamingService;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

public class HistoricalStreamingServiceListener<T> extends ServiceListener<PriceStream<T>> {
    HistoricalStreamingService<T> service;

    public HistoricalStreamingServiceListener(HistoricalStreamingService<T> service) {
        this.service = service;
    }

    @Override
    public void ProcessAdd(PriceStream<T> data) {
        Product product = (Product) data.getProduct();
        if (product instanceof Bond) {
            service.PersistData(product.getProductId(), data);
        }
    }

    @Override
    public void ProcessRemove(PriceStream<T> data) {

    }

    @Override
    public void ProcessUpdate(PriceStream<T> data) {

    }
}
