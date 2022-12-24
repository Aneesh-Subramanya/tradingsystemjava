package main.java.listeners;

import main.constants.UtilConstants;
import main.java.entities.ExecutionOrder;
import main.java.entities.Trade;
import main.java.products.Product;
import main.java.services.TradeBookingService;
import main.utils.UtilFunctions;

import java.util.Random;

public class TradeBookingServiceListener<T> extends ServiceListener<ExecutionOrder<T>> {
    private TradeBookingService<T> tradeBookingService;
    private static final Random RANDOM = new Random();

    public TradeBookingServiceListener(TradeBookingService<T> tradeBookingService) {
        this.tradeBookingService = tradeBookingService;
    }

    public TradeBookingService<T> getTradeBookingService() {
        return tradeBookingService;
    }

    public void setTradeBookingService(TradeBookingService<T> tradeBookingService) {
        this.tradeBookingService = tradeBookingService;
    }

    @Override
    public void ProcessAdd(ExecutionOrder<T> data) {

        String book = UtilConstants.BOOKS.get(RANDOM.nextInt(UtilConstants.BOOKS.size()));
        Product product = (Product) data.getProduct();
        Trade<T> trade = new Trade<>(
                data.getProduct(),
                data.getPrice(),
                book,
                (data.getVisibleQuantity() + data.getHiddenQuantity()),
                UtilFunctions.getTradeSide(data.getSide())
        );

        tradeBookingService.BookTrade(trade);
    }

    @Override
    public void ProcessRemove(ExecutionOrder<T> data) {

    }

    @Override
    public void ProcessUpdate(ExecutionOrder<T> data) {

    }
}
