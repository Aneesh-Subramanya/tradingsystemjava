package main.java.publishers;

import main.constants.UtilConstants;
import main.java.connectors.Connector;

import java.io.*;
import java.net.Socket;

public class InquiryServicePublisher extends Connector<String> implements Runnable {
    @Override
    public void Publish(String fileName) {
        try {
            Socket socket = new Socket(UtilConstants.INQUIRYSERVICEURL, UtilConstants.INQUIRYSERVICEPORT);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            File file = new File(fileName);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    dout.writeUTF(line);
                    dout.flush();
                }
                dout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Publish(UtilConstants.INQUIRYSERVICEFILE);
    }
}
