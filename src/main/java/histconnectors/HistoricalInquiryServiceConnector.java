package main.java.histconnectors;

import main.constants.UtilConstants;
import main.java.connectors.Connector;
import main.java.entities.Inquiry;

import java.io.File;
import java.sql.Timestamp;

public class HistoricalInquiryServiceConnector<T> extends Connector<Inquiry<T>> {
    public static final File FILE = new File(UtilConstants.HISTORICAL_ALLINQUIRIES_FILE);

    @Override
    public void Publish(Inquiry<T> data) {
        // publish string
        String str = new Timestamp(System.currentTimeMillis()) + ", " + data.toString();
        WriteToFile(str, FILE);
    }
}
