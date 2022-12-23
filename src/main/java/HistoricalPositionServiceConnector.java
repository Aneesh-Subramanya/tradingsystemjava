package main.java;

import java.io.File;

public class HistoricalPositionServiceConnector<T> extends Connector<Position<T>> {
    public static final File FILE = new File("support/positions.txt");

    @Override
    public void Publish(Position<T> data) {
        // publish string
        String str = "HPSC";
        WriteToFile(str, FILE);
    }
}
