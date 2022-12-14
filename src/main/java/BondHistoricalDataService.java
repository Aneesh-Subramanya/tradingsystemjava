package main.java;

import java.util.List;

/**
 * Service for processing and persisting historical data to a persistent store.
 * Keyed on some persistent key.
 * Type T is the data type to persist.
 */
public class BondHistoricalDataService<T> extends HistoricalDataService<T> {
    // Persist data to a store
    public void PersistData(String persistKey, T data) {

    }

    @Override
    public T GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(T data) {

    }

    @Override
    public void AddListener(ServiceListener<T> listener) {

    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return null;
    }
}
