package main.java.histservices;

import main.java.connectors.Connector;
import main.java.entities.Inquiry;
import main.java.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class HistoricalInquiryService<T> extends HistoricalDataService<T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();
    Connector<Inquiry<T>> connector;

    public HistoricalInquiryService(Connector<Inquiry<T>> connector) {
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
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return listeners;
    }
}
