package main.java.services;

import main.enums.Side;
import main.java.entities.Position;
import main.java.entities.Trade;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Position Service to manage positions across multiple books and secruties.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class PositionService<T> extends Service<String, Position<T>> {
    private final Map<String, Position<T>> positionsMap = new HashMap<>();
    private final List<ServiceListener<Position<T>>> listeners = new ArrayList<>();

    // Add a trade to the service
    public void AddTrade(Trade<T> trade) {
        Product product = (Product) trade.getProduct();
        if (product instanceof Bond) {
            String productId = product.getProductId();
            Long quantity = trade.getSide() == Side.BUY ? trade.getQuantity() : -trade.getQuantity();
            String book = trade.getBook();
            Position<T> position = positionsMap.get(productId);
            if (position == null) {
                Map<String, Long> pos = new HashMap<>();
                pos.put(book, trade.getQuantity());
                position = new Position<T>((T) product, pos);
                positionsMap.put(productId, position);
            } else {
                position.updatePosition(book, quantity);
            }
            OnMessage(position);
        }
    }

    @Override
    public Position<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Position<T> data) {
        T product = data.getProduct();
        if (product instanceof Bond) {
            String productId = ((Bond) product).getProductId();
            for (ServiceListener<Position<T>> listener : listeners) {
                listener.ProcessAdd(data);
            }
        }
    }

    @Override
    public void AddListener(ServiceListener<Position<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<Position<T>>> GetListeners() {
        return listeners;
    }
}
