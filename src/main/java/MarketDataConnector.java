package main.java;

import main.enums.PricingSide;
import main.utils.UtilFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class MarketDataConnector<T> extends Connector<OrderBook<T>> {
    private MarketDataService<T> service;

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

    public void Subscribe(FileReader fileReader) throws IOException {
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        String productId = null;
        List<Order> bidStack = new ArrayList<>();
        List<Order> offerStack = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                // TMUBMUSD02Y 1000000 98-317 99-001 1000000
                String[] parts = line.split(" ");
                productId = parts[0];
                int bidQty = Integer.parseInt(parts[1]);
                double bidPrice = UtilFunctions.convertToDecimalPrice(parts[2]);
                int offerQty = Integer.parseInt(parts[3]);
                double offerPrice = UtilFunctions.convertToDecimalPrice(parts[4]);

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

                service.OnMessage(orderBook);
            }
        }
        br.close();
    }
}
