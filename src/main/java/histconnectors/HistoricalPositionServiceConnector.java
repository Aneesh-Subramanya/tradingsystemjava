package main.java.histconnectors;

import main.constants.UtilConstants;
import main.java.connectors.Connector;
import main.java.entities.Position;

import java.io.File;
import java.sql.Timestamp;

public class HistoricalPositionServiceConnector<T> extends Connector<Position<T>> {
    public static final File FILE = new File(UtilConstants.HISTORICAL_POSITIONS_FILE);

    @Override
    public void Publish(Position<T> data) {
        // publish string
        String str = new Timestamp(System.currentTimeMillis()) + ", " + data.toString();
        WriteToFile(str, FILE);
    }
}
