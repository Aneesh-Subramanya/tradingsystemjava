package main.java;

import java.util.List;

public class HistoricalinquiryService<T> extends HistoricalDataService<T> {
    Connector<Inquiry<T>> connector;

    public HistoricalinquiryService(Connector<Inquiry<T>> connector) {
        this.connector = connector;
    }

    public Connector<Inquiry<T>> getConnector() {
        return connector;
    }

    public void setConnector(Connector<Inquiry<T>> connector) {
        this.connector = connector;
    }

    public void PersistData(String persistKey, Inquiry<T> data) {
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
