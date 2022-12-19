package main.java;

import main.enums.Market;

import java.util.List;
import java.util.Map;

/**
 * Service for executing orders on an exchange.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class ExecutionService<T> extends Service<String, ExecutionOrder<T>> {

    private Map<String, ExecutionOrder<T>> executionOrderMap;
    private List<ServiceListener<ExecutionOrder<T>>> listeners;

    public ExecutionService(Map<String, ExecutionOrder<T>> executionOrderMap, List<ServiceListener<ExecutionOrder<T>>> listeners) {
        this.executionOrderMap = executionOrderMap;
        this.listeners = listeners;
    }

    public Map<String, ExecutionOrder<T>> getExecutionOrderMap() {
        return executionOrderMap;
    }

    public void setExecutionOrderMap(Map<String, ExecutionOrder<T>> executionOrderMap) {
        this.executionOrderMap = executionOrderMap;
    }

    public List<ServiceListener<ExecutionOrder<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<ExecutionOrder<T>>> listeners) {
        this.listeners = listeners;
    }

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
