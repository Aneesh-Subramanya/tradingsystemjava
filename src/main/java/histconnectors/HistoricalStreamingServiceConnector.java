package main.java.histconnectors;

import main.constants.UtilConstants;
import main.java.connectors.Connector;
import main.java.entities.PriceStream;

import java.io.File;
import java.sql.Timestamp;

public class HistoricalStreamingServiceConnector<T> extends Connector<PriceStream<T>> {
    public static final File FILE = new File(UtilConstants.HISTORICAL_STREAMING_FILE);

    @Override
    public void Publish(PriceStream<T> data) {
        // publish string
        String str = new Timestamp(System.currentTimeMillis()) + ", " + data.toString();
        WriteToFile(str, FILE);
    }
}
