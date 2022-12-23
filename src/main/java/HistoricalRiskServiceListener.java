package main.java;

public class HistoricalRiskServiceListener<T> extends ServiceListener<PV01<T>> {

    HistoricalRiskService<T> service;

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
