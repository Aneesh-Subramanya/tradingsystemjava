package main.java.histconnectors;

import main.constants.UtilConstants;
import main.java.connectors.Connector;
import main.java.entities.PV01;

import java.io.File;
import java.sql.Timestamp;

public class HistoricalRiskServiceConnector<T> extends Connector<PV01<T>> {
    public static final File FILE = new File(UtilConstants.HISTORICAL_RISK_FILE);

    @Override
    public void Publish(PV01<T> data) {
        // publish string
        String str = new Timestamp(System.currentTimeMillis()) + ", " + data.toString();
        WriteToFile(str, FILE);
    }
}
