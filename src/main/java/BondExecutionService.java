package main.java;

import main.enums.Market;

import java.util.List;

/**
 * Service for executing orders on an exchange.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class BondExecutionService<T> extends ExecutionService<T> {
    // Execute an order on a market
    public void ExecuteOrder(ExecutionOrder<T> order, Market market) {

    }

    @Override
    public ExecutionOrder<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(ExecutionOrder<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<ExecutionOrder<T>> listener) {

    }

    @Override
    public List<ServiceListener<ExecutionOrder<T>>> GetListeners() {
        return null;
    }
}
