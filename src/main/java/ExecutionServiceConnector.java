package main.java;

import main.constants.UtilConstants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ExecutionServiceConnector<T> extends Connector<ExecutionOrder<T>> {
    @Override
    public void Publish(ExecutionOrder<T> data) {
        try {
            Socket socket = new Socket(UtilConstants.EXECUTIONSERVICEURL, UtilConstants.EXECUTIONSERVICEPORT);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(data.toString());
            dout.flush();
            dout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
