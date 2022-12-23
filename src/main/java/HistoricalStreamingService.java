package main.java;

import java.util.List;

public class HistoricalStreamingService<T> extends HistoricalDataService<T> {
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

    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return null;
    }
}
