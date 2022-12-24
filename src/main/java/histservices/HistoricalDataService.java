package main.java.histservices;

import main.java.listeners.ServiceListener;
import main.java.services.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for processing and persisting historical data to a persistent store.
 * Keyed on some persistent key.
 * Type T is the data type to persist.
 */
public class HistoricalDataService<T> extends Service<String, T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();

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
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return listeners;
    }
}
