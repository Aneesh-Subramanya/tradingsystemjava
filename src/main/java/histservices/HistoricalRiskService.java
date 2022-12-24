package main.java.histservices;

import main.java.connectors.Connector;
import main.java.entities.PV01;
import main.java.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class HistoricalRiskService<T> extends HistoricalDataService<T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();
    Connector<PV01<T>> connector;

    public HistoricalRiskService(Connector<PV01<T>> connector) {
        this.connector = connector;
    }

    public Connector<PV01<T>> getConnector() {
        return connector;
    }

    public void setConnector(Connector<PV01<T>> connector) {
        this.connector = connector;
    }

    public void PersistData(String persistKey, PV01<T> data) {
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
