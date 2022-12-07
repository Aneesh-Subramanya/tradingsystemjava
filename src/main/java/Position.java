package main.java;

import java.util.Map;

/**
 * Position class in a particular book.
 * Type T is the product type.
 */
public class Position<T> {
    private T product;
    Map<String, Long> positions;

    public Position(T product, Map<String, Long> positions) {
        this.product = product;
        this.positions = positions;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public Map<String, Long> getPositions() {
        return positions;
    }

    public void setPositions(Map<String, Long> positions) {
        this.positions = positions;
    }
}
