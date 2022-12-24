package main.java.histlisteners;

import main.java.entities.Position;
import main.java.histservices.HistoricalPositionService;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

public class HistoricalPositionServiceListener<T> extends ServiceListener<Position<T>> {
    HistoricalPositionService<T> service;

    public HistoricalPositionServiceListener(HistoricalPositionService<T> service) {
        this.service = service;
    }

    @Override
    public void ProcessAdd(Position<T> data) {
        Product product = (Product) data.getProduct();
        if (product instanceof Bond) {
            service.PersistData(product.getProductId(), data);
        }
    }

    @Override
    public void ProcessRemove(Position<T> data) {

    }

    @Override
    public void ProcessUpdate(Position<T> data) {

    }
}
