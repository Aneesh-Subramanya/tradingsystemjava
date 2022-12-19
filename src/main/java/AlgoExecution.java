package main.java;

public class AlgoExecution<T> {
    private ExecutionOrder<T> executionOrder;

    public AlgoExecution(ExecutionOrder<T> executionOrder) {
        this.executionOrder = executionOrder;
    }

    public ExecutionOrder<T> getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(ExecutionOrder<T> executionOrder) {
        this.executionOrder = executionOrder;
    }
}
