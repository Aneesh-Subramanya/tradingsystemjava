package main.java.connectors;

import main.constants.UtilConstants;
import main.java.entities.ExecutionOrder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ExecutionServiceConnector<T> extends Connector<ExecutionOrder<T>> {
    Socket socket;

    {
        try {
            socket = new Socket(UtilConstants.EXECUTIONSERVICEURL, UtilConstants.EXECUTIONSERVICEPORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Publish(ExecutionOrder<T> data) {
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
