package main.java.subscribers;

import main.constants.UtilConstants;
import main.java.connectors.Connector;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StreamingServiceSubscriber extends Connector<String> implements Runnable {
    @Override
    public void Publish(String data) {

    }

    public void Subscribe(String fileName) {
        try {
            ServerSocket ss = new ServerSocket(UtilConstants.STREAMINGSERVICEPORT);

            Socket socket = ss.accept(); // Establishes connection
            DataInputStream din = new DataInputStream(socket.getInputStream());

            File file = new File(fileName);
            Logger logger = Logger.getLogger("");
            FileHandler fh = new FileHandler(fileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            while (true) {
                String line = din.readUTF();
                if (line.length() > 0) {
                    logger.info("StreamingService: " + line);
                } else {
                    // Don't hammer the socket - Sleep for 1 second when socket is empty.
                    Thread.sleep(1000);
                }
            }
        } catch (EOFException ignored) {
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Subscribe(UtilConstants.STREAMINGSERVICEFILE);
    }


}
