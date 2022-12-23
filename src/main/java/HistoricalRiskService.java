package main.java;

import java.util.List;

public class HistoricalRiskService<T> extends HistoricalDataService<T> {
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

    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return null;
    }
}
