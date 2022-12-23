package main.java;

import java.io.File;

public class HistoricalInquiryServiceConnector<T> extends Connector<Inquiry<T>> {
    public static final File FILE = new File("support/allinquiries.txt");

    @Override
    public void Publish(Inquiry<T> data) {
        // publish string
        String str = "HISC";
        WriteToFile(str, FILE);
    }
}
