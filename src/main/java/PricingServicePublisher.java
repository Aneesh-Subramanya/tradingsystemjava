package main.java;

import main.constants.UtilConstants;

import java.io.*;
import java.net.Socket;

public class PricingServicePublisher extends Connector<String> implements Runnable {
    @Override
    public void Publish(String fileName) {
        try {
            Socket socket = new Socket(UtilConstants.PRICINGSERVICEURL, UtilConstants.PRICINGSERVICEPORT);
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
        Publish(UtilConstants.PRICINGSERVICEFILE);
    }
}
