package main.java;

import main.constants.UtilConstants;
import main.enums.InquiryState;
import main.enums.Side;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InquiryServiceConnector<T> extends Connector<Inquiry<T>> implements Runnable {
    private InquiryService<T> service;

    public InquiryServiceConnector(InquiryService<T> service) {
        this.service = service;
    }

    public InquiryService<T> getService() {
        return service;
    }

    public void setService(InquiryService<T> service) {
        this.service = service;
    }

    @Override
    public void Publish(Inquiry<T> data) {
        if (data.getState() == InquiryState.RECEIVED) {
            double price = data.getPrice();
            data.setState(InquiryState.QUOTED);
            service.OnMessage(data);
            data.setState(InquiryState.DONE);
            service.OnMessage(data);
        }
    }

    public void Subscribe() {
        try {
            ServerSocket ss = new ServerSocket(UtilConstants.INQUIRYSERVICEPORT);

            Socket socket = ss.accept(); // Establishes connection
            DataInputStream din = new DataInputStream(socket.getInputStream());

            String productId = null;
            while (true) {
                String line = din.readUTF();
                if (line.length() > 0) {
                    // INQ22122300001 TMUBMUSD02Y BUY 1000000 RECEIVED
                    String[] parts = line.split(" ");
                    String inquiryId = parts[0];
                    productId = parts[1];
                    Side side = Side.valueOf(parts[2]);
                    long quantity = Long.parseLong(parts[3]);
                    InquiryState state = InquiryState.valueOf(parts[4]);

                    Product bond = Bond.GetBond(productId);
                    Inquiry<T> inquiry = new Inquiry<T>(inquiryId, (T) bond, side, quantity, null, state);
                    service.OnMessage(inquiry);
                    System.out.println("inquiry");
                }
            }
        } catch (EOFException ignored) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Subscribe();
    }
}
