package main.java.histlisteners;

import main.java.entities.ExecutionOrder;
import main.java.histservices.HistoricalExecutionService;
import main.java.listeners.ServiceListener;

public class HistoricalExecutionServiceListener<T> extends ServiceListener<ExecutionOrder<T>> {
    HistoricalExecutionService<T> service;

    public HistoricalExecutionServiceListener(HistoricalExecutionService<T> service) {
        this.service = service;
    }

    @Override
    public void ProcessAdd(ExecutionOrder<T> data) {
        service.PersistData(data.getOrderId(), data);
    }

    @Override
    public void ProcessRemove(ExecutionOrder<T> data) {

    }

    @Override
    public void ProcessUpdate(ExecutionOrder<T> data) {

    }
}
