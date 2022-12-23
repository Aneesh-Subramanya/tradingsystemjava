package main.java;

import main.constants.UtilConstants;
import main.enums.PricingSide;
import main.utils.UtilFunctions;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Connector class.
 * This will invoke the Service.OnMessage() method for subscriber Connectors
 * to push data to the Service.
 * Services can invoke the Publish() method on this Service to publish data to the Connector
 * for a publisher Connector.
 * Note that a Connector can be publisher-only, subscriber-only, or both publisher and susbcriber.
 */
public class MarketDataConnector<T> extends Connector<OrderBook<T>> implements Runnable {
    private MarketDataService<T> service;

    public MarketDataConnector() {
    }

    public MarketDataConnector(MarketDataService<T> service) {
        this.service = service;
    }

    public MarketDataService<T> getService() {
        return service;
    }

    public void setService(MarketDataService<T> service) {
        this.service = service;
    }

    // Publish data to the Connector
    @Override
    public void Publish(OrderBook<T> data) {

    }

    public void Subscribe() {
        try {
            ServerSocket ss = new ServerSocket(UtilConstants.MARKETDATAPORT);

            Socket socket = ss.accept(); // Establishes connection
            DataInputStream din = new DataInputStream(socket.getInputStream());

            String productId = null;
            List<Order> bidStack = new ArrayList<>();
            List<Order> offerStack = new ArrayList<>();
            while (true) {
                String line = din.readUTF();
                if (line.length() > 0) {
                    // TMUBMUSD02Y 1000000 98-317 99-001 1000000
                    String[] parts = line.split(" ");
                    productId = parts[0];
                    int bidQty = Integer.parseInt(parts[1]);
                    double bidPrice = UtilFunctions.convertToDecimalPrice(parts[2]);
                    double offerPrice = UtilFunctions.convertToDecimalPrice(parts[3]);
                    int offerQty = Integer.parseInt(parts[4]);

                    Order bidOrder = new Order(bidPrice, bidQty, PricingSide.BID);
                    Order offerOrder = new Order(offerPrice, offerQty, PricingSide.OFFER);

                    bidStack.add(bidOrder);
                    offerStack.add(offerOrder);
                } else {
                    assert productId != null;
                    Bond bond = Bond.GetBond(productId);
                    OrderBook<T> orderBook = new OrderBook<T>((T) bond, bidStack, offerStack);
                    bidStack = new ArrayList<>();
                    offerStack = new ArrayList<>();
                    // service.OnMessage(orderBook);
                    System.out.println("mark");
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
