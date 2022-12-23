package main.java;

import java.io.File;

public class HistoricalExecutionServiceConnector<T> extends Connector<ExecutionOrder<T>> {
    public static final File FILE = new File("support/executions.txt");

    @Override
    public void Publish(ExecutionOrder<T> data) {
        // publish string
        String str = "HESC";
        WriteToFile(str, FILE);
    }
}
