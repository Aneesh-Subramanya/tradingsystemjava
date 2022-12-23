package main.java;

import main.constants.UtilConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIService<T> extends Service<String, Price<T>> {

    private final Map<String, Price<T>> guiServiceMap = new HashMap<>();
    private final List<ServiceListener<Price<T>>> listeners = new ArrayList<>();
    private GUIServiceConnector<T> connector;
    private int counter = 0;


    @Override
    public Price<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Price<T> data) {
        Product product = (Product) data.getProduct();
        if (product instanceof Bond) {
            guiServiceMap.put(product.productId, data);
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

    }

    @Override
    public List<ServiceListener<Price<T>>> GetListeners() {
        return null;
    }
}
