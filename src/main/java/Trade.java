package main.java;

import main.enums.ProductType;
import main.enums.Side;

/**
 * Trade object with a price, side, and quantity on a particular book.
 * Type T is the product type.
 */
public class Trade<T> {
    T product;
    String tradeId;
    double price;
    String book;
    double quantity;
    Side side;

    private static long counter = 1;

    private String generateTradeId() {
        if (product instanceof Product) {
            ProductType type = ((Product) product).getProductType();
            String tradeId = type + book + String.format("%25d", counter);
            counter++;
            return tradeId;
        }
        return null;
    }

    public Trade(T product, double price, String book, double quantity, Side side) {
        this.product = product;
        this.tradeId = generateTradeId();
        this.price = price;
        this.book = book;
        this.quantity = quantity;
        this.side = side;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
