package main.java;

public class AlgoExecutionServiceListener<T> extends ServiceListener<OrderBook<T>> {

    private AlgoExecutionService<T> algoExecutionService;

    public AlgoExecutionServiceListener(AlgoExecutionService<T> algoExecutionService) {
        this.algoExecutionService = algoExecutionService;
    }

    public AlgoExecutionService<T> getAlgoExecutionService() {
        return algoExecutionService;
    }

    public void setAlgoExecutionService(AlgoExecutionService<T> algoExecutionService) {
        this.algoExecutionService = algoExecutionService;
    }

    @Override
    public void ProcessAdd(OrderBook<T> data) {
        algoExecutionService.addOrder(data);
    }

    @Override
    public void ProcessRemove(OrderBook<T> data) {

    }

    @Override
    public void ProcessUpdate(OrderBook<T> data) {

    }
}
