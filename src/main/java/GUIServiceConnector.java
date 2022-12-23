package main.java;

import main.constants.UtilConstants;

import java.io.File;

public class GUIServiceConnector<T> extends Connector<Price<T>> {
    @Override
    public void Publish(Price<T> data) {
        String str = System.currentTimeMillis() + data.toString();
        File file = new File(UtilConstants.GUIFILE);
        WriteToFile(str, file);
    }
}
