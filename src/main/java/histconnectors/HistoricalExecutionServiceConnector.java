package main.java.histconnectors;

import main.constants.UtilConstants;
import main.java.connectors.Connector;
import main.java.entities.ExecutionOrder;

import java.io.File;
import java.sql.Timestamp;

public class HistoricalExecutionServiceConnector<T> extends Connector<ExecutionOrder<T>> {
    public static final File FILE = new File(UtilConstants.HISTORICAL_EXECUTIONS_FILE);

    @Override
    public void Publish(ExecutionOrder<T> data) {
        // publish string
        String str = new Timestamp(System.currentTimeMillis()) + ", " + data.toString();
        WriteToFile(str, FILE);
    }
}
