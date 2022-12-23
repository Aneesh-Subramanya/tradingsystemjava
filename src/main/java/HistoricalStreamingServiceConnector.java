package main.java;

import java.io.File;

public class HistoricalStreamingServiceConnector<T> extends Connector<PriceStream<T>> {
    public static final File FILE = new File("support/streaming.txt");

    @Override
    public void Publish(PriceStream<T> data) {
        // publish string
        String str = "HSSC";
        WriteToFile(str, FILE);
    }
}
