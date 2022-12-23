package main.java;

import main.enums.Market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for executing orders on an exchange.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class ExecutionService<T> extends Service<String, ExecutionOrder<T>> {

    private final Map<String, ExecutionOrder<T>> executionOrderMap = new HashMap<>();
    private final List<ServiceListener<ExecutionOrder<T>>> listeners = new ArrayList<>();
    private final Connector<ExecutionOrder<T>> connector = new ExecutionServiceConnector<T>();

    public void ExecuteOrder(ExecutionOrder<T> data, Market market) {
        T product = data.getProduct();
        if (product instanceof Product) {
            String productId = ((Product) product).getProductId();
            this.executionOrderMap.put(productId, data);
            this.OnMessage(data);
        }
    }

    @Override
    public ExecutionOrder<T> GetData(String key) {
        return executionOrderMap.get(key);
    }

    @Override
    public void OnMessage(ExecutionOrder<T> data) {
        for (ServiceListener<ExecutionOrder<T>> listener : listeners) {
            listener.ProcessAdd(data);
        }
        connector.Publish(data);
    }

    @Override
    public void AddListener(ServiceListener<ExecutionOrder<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<ExecutionOrder<T>>> GetListeners() {
        return listeners;
    }
}
