package main.java.listeners;

import main.enums.Market;
import main.java.entities.AlgoExecution;
import main.java.entities.ExecutionOrder;
import main.java.services.ExecutionService;

public class ExecutionServiceListener<T> extends ServiceListener<AlgoExecution<T>> {

    private ExecutionService<T> executionService;

    public ExecutionServiceListener(ExecutionService<T> executionService) {
        this.executionService = executionService;
    }

    public ExecutionService<T> getExecutionService() {
        return executionService;
    }

    public void setExecutionService(ExecutionService<T> executionService) {
        this.executionService = executionService;
    }

    @Override
    public void ProcessAdd(AlgoExecution<T> data) {
        ExecutionOrder<T> executionOrder = data.getExecutionOrder();
        Market market = Market.CME; // Executing only on CME for now
        executionService.ExecuteOrder(executionOrder, market);
    }

    @Override
    public void ProcessRemove(AlgoExecution<T> data) {

    }

    @Override
    public void ProcessUpdate(AlgoExecution<T> data) {

    }
}
