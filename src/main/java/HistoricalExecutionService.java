package main.java;

import java.util.List;

public class HistoricalExecutionService<T> extends HistoricalDataService<T> {
    Connector<ExecutionOrder<T>> connector;

    public HistoricalExecutionService(Connector<ExecutionOrder<T>> connector) {
        this.connector = connector;
    }

    public Connector<ExecutionOrder<T>> getConnector() {
        return connector;
    }

    public void setConnector(Connector<ExecutionOrder<T>> connector) {
        this.connector = connector;
    }

    public void PersistData(String persistKey, ExecutionOrder<T> data) {
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
