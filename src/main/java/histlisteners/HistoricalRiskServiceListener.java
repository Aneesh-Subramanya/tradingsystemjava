package main.java.histlisteners;

import main.java.entities.PV01;
import main.java.histservices.HistoricalRiskService;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

public class HistoricalRiskServiceListener<T> extends ServiceListener<PV01<T>> {
    HistoricalRiskService<T> service;

    public HistoricalRiskServiceListener(HistoricalRiskService<T> service) {
        this.service = service;
    }

    @Override
    public void ProcessAdd(PV01<T> data) {
        Product product = (Product) data.getProduct();
        if (product instanceof Bond) {
            service.PersistData(product.getProductId(), data);
        }
    }

    @Override
    public void ProcessRemove(PV01<T> data) {

    }

    @Override
    public void ProcessUpdate(PV01<T> data) {

    }
}
