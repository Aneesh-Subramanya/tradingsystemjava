package main.java;

import java.io.File;

public class HistoricalRiskServiceConnector<T> extends Connector<PV01<T>> {
    public static final File FILE = new File("risk.txt");

    @Override
    public void Publish(PV01<T> data) {
        // publish string
        String str = null;
        WriteToFile(str, FILE);
    }
}
