package main.java.services;

import main.constants.UtilConstants;
import main.enums.OrderType;
import main.enums.PricingSide;
import main.java.entities.*;
import main.java.listeners.ServiceListener;
import main.java.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoExecutionService<T> extends Service<String, AlgoExecution<T>> {
    private static Long orderId = 1L;
    private final Map<String, AlgoExecution<T>> algoExecutionMap = new HashMap<>();
    private final List<ServiceListener<AlgoExecution<T>>> listeners = new ArrayList<>();
    private PricingSide side = PricingSide.BID;

    @Override
    public AlgoExecution<T> GetData(String key) {
        return algoExecutionMap.get(key);
    }

    @Override
    public void OnMessage(AlgoExecution<T> data) {
        for (ServiceListener<AlgoExecution<T>> listener : listeners) {
            listener.ProcessAdd(data);
        }
    }

    @Override
    public void AddListener(ServiceListener<AlgoExecution<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<AlgoExecution<T>>> GetListeners() {
        return listeners;
    }

    public void addOrder(OrderBook<T> data) {
        T product = data.getProduct();
        if (product instanceof Product) {
            String productId = ((Product) product).getProductId();
            BidOffer bidOffer = data.GetBidOffer();
            if (bidOffer.getOfferOrder().getPrice() - bidOffer.getBidOrder().getPrice() <= UtilConstants.ONE_128) {
                Order order = this.side == PricingSide.BID ? bidOffer.getBidOrder() : bidOffer.getOfferOrder();

                ExecutionOrder<T> executionOrder = new ExecutionOrder<>(
                        product,
                        this.side,
                        "ORD" + orderId,
                        OrderType.MARKET,
                        order.getPrice(),
                        order.getQuantity(),
                        0,
                        null,
                        false
                );

                AlgoExecution<T> algoExecution = new AlgoExecution<>(executionOrder);
                this.algoExecutionMap.put(productId, algoExecution);

                this.side = this.side == PricingSide.BID ? PricingSide.OFFER : PricingSide.BID;
                orderId++;

                this.OnMessage(algoExecution);
            }
        }
    }
}
