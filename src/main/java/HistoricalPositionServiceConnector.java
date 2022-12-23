package main.java;

import java.io.File;

public class HistoricalPositionServiceConnector<T> extends Connector<Position<T>> {
    public static final File FILE = new File("positions.txt");

    @Override
    public void Publish(Position<T> data) {
        // publish string
        String str = null;
        WriteToFile(str, FILE);
    }
}
