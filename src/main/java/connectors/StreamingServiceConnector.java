package main.java.connectors;

import main.constants.UtilConstants;
import main.java.entities.PriceStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class StreamingServiceConnector<T> extends Connector<PriceStream<T>> {
    Socket socket;

    {
        try {
            socket = new Socket(UtilConstants.STREAMINGSERVICEURL, UtilConstants.STREAMINGSERVICEPORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Publish(PriceStream<T> data) {
        try {
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(data.toString());
            dout.flush();
            // dout.close();
            Thread.sleep(300);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
