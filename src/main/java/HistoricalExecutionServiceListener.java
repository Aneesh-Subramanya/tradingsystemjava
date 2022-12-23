package main.java;

public class HistoricalExecutionServiceListener<T> extends ServiceListener<ExecutionOrder<T>> {

    HistoricalExecutionService<T> service;

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
