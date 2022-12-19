package main.java;

import main.enums.Side;
import main.utils.UtilFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TradeBookingConnector<T> extends Connector<Trade<T>> {
    private TradeBookingService<T> service;

    public TradeBookingConnector(TradeBookingService<T> service) {
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

    public void Subscribe(FileReader fileReader) throws IOException {
        // TMUBMUSD02Y TRSY1 BUY 1000000 99-000
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        String productId = null;
        List<Order> bidStack = new ArrayList<>();
        List<Order> offerStack = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                String[] parts = line.split(" ");
                productId = parts[0];
                String book = parts[1];
                Side side = Side.valueOf(parts[2]);
                double quantity = Double.parseDouble(parts[3]);
                double price = UtilFunctions.convertToDecimalPrice(parts[4]);

                Product bond = Bond.GetBond(productId);
                Trade<T> trade = new Trade<T>((T) bond, price, book, quantity, side);
                service.OnMessage(trade);
            }
        }
        br.close();
    }
}
