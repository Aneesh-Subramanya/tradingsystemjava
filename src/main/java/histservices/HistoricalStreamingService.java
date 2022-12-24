package main.java.histservices;

import main.java.connectors.Connector;
import main.java.entities.PriceStream;
import main.java.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class HistoricalStreamingService<T> extends HistoricalDataService<T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();
    Connector<PriceStream<T>> connector;

    public HistoricalStreamingService(Connector<PriceStream<T>> connector) {
        this.connector = connector;
    }

    public Connector<PriceStream<T>> getConnector() {
        return connector;
    }

    public void setConnector(Connector<PriceStream<T>> connector) {
        this.connector = connector;
    }

    public void PersistData(String persistKey, PriceStream<T> data) {
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
