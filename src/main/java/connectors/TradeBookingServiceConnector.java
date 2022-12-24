package main.java.connectors;

import main.constants.UtilConstants;
import main.enums.Side;
import main.java.entities.Trade;
import main.java.products.Bond;
import main.java.products.Product;
import main.java.services.TradeBookingService;
import main.utils.UtilFunctions;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TradeBookingServiceConnector<T> extends Connector<Trade<T>> implements Runnable {
    private TradeBookingService<T> service;

    public TradeBookingServiceConnector(TradeBookingService<T> service) {
        this.service = service;
    }

    public TradeBookingService<T> getService() {
        return service;
    }

    public void setService(TradeBookingService<T> service) {
        this.service = service;
    }

    // Publish data to the Connector
    @Override
    public void Publish(Trade<T> data) {

    }

    public void Subscribe() {
        try {
            ServerSocket ss = new ServerSocket(UtilConstants.BOOKINGSERVICEPORT);

            Socket socket = ss.accept(); // Establishes connection
            DataInputStream din = new DataInputStream(socket.getInputStream());

            String productId = null;
            while (true) {
                String line = din.readUTF();
                if (line.length() > 0) {
                    // TMUBMUSD02Y TRSY2 BUY 1000000 99-000
                    String[] parts = line.split(" ");
                    productId = parts[0];
                    String book = parts[1];
                    Side side = Side.valueOf(parts[2]);
                    long quantity = Long.parseLong(parts[3]);
                    double price = UtilFunctions.convertToDecimalPrice(parts[4]);

                    Product bond = Bond.GetBond(productId);
                    Trade<T> trade = new Trade<T>((T) bond, price, book, quantity, side);
                    service.OnMessage(trade);
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
