package main.java;

import main.constants.UtilConstants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class StreamingServiceConnector<T> extends Connector<PriceStream<T>> {
    @Override
    public void Publish(PriceStream<T> data) {
        try {
            Socket socket = new Socket(UtilConstants.STREAMINGSERVICEURL, UtilConstants.STREAMINGSERVICEPORT);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(data.toString());
            dout.flush();
            dout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
