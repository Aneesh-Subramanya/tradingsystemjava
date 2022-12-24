package main.java.histservices;

import main.java.connectors.Connector;
import main.java.entities.Position;
import main.java.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class HistoricalPositionService<T> extends HistoricalDataService<T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();
    Connector<Position<T>> connector;

    public HistoricalPositionService(Connector<Position<T>> connector) {
        this.connector = connector;
    }

    public Connector<Position<T>> getConnector() {
        return connector;
    }

    public void setConnector(Connector<Position<T>> connector) {
        this.connector = connector;
    }

    public void PersistData(String persistKey, Position<T> data) {
        connector.Publish(data);
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
