package main.java.connectors;

import main.constants.UtilConstants;
import main.java.entities.Price;

import java.io.File;
import java.sql.Timestamp;
import java.util.logging.Logger;

public class GUIServiceConnector<T> extends Connector<Price<T>> {
    @Override
    public void Publish(Price<T> data) {
        String str = new Timestamp(System.currentTimeMillis()) + data.toString();
        File file = new File(UtilConstants.GUIFILE);
        Logger logger = Logger.getLogger("");
        logger.info("GUIService: " + str);
        WriteToFile(str, file);
    }
}
