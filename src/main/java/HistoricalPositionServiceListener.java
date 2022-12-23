package main.java;

public class HistoricalPositionServiceListener<T> extends ServiceListener<Position<T>> {

    HistoricalPositionService<T> service;

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
