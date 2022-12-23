package main.java;

import main.constants.UtilConstants;
import main.utils.UtilFunctions;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PricingServiceConnector<T> extends Connector<Price<T>> implements Runnable {
    private PricingService<T> service;

    public PricingServiceConnector(PricingService<T> service) {
        this.service = service;
    }

    public PricingService<T> getService() {
        return service;
    }

    public void setService(PricingService<T> service) {
        this.service = service;
    }

    @Override
    public void Publish(Price<T> data) {

    }

    public void Subscribe() {
        try {
            ServerSocket ss = new ServerSocket(UtilConstants.PRICINGSERVICEPORT);

            Socket socket = ss.accept(); // Establishes connection
            DataInputStream din = new DataInputStream(socket.getInputStream());

            String productId = null;
            while (true) {
                String line = din.readUTF();
                if (line.length() > 0) {
                    // TMUBMUSD02Y 98-317 99-001
                    String[] parts = line.split(" ");
                    productId = parts[0];
                    double bidPrice = UtilFunctions.convertToDecimalPrice(parts[1]);
                    double offerPrice = UtilFunctions.convertToDecimalPrice(parts[2]);

                    double midPrice = (bidPrice + offerPrice) / 2;
                    double bidOfferSpread = offerPrice - bidPrice;
                    Product bond = Bond.GetBond(productId);
                    Price<T> price = new Price<T>((T) bond, midPrice, bidOfferSpread);
                    // service.OnMessage(trade);
                    System.out.println("price");
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
