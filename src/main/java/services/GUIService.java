package main.java.services;

import main.constants.UtilConstants;
import main.java.connectors.GUIServiceConnector;
import main.java.entities.Price;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIService<T> extends Service<String, Price<T>> {

    private final Map<String, Price<T>> guiServiceMap = new HashMap<>();
    private final List<ServiceListener<Price<T>>> listeners = new ArrayList<>();
    private final GUIServiceConnector<T> connector = new GUIServiceConnector<>();
    private int counter = 0;


    @Override
    public Price<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Price<T> data) {
        Product product = (Product) data.getProduct();
        if (product instanceof Bond) {
            guiServiceMap.put(product.getProductId(), data);
            if (counter < UtilConstants.UPDATES_TO_PRINT) {
                connector.Publish(data);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
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
