package main.java;

import main.enums.Market;

/**
 * Service for executing orders on an exchange.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class ExecutionService<T> extends Service<String, ExecutionOrder<T>> {
    public abstract void ExecuteOrder(ExecutionOrder<T> order, Market market);
}
