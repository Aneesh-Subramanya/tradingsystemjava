package main.java.entities;

import main.enums.ProductType;
import main.enums.Side;
import main.java.products.Product;

/**
 * Trade object with a price, side, and quantity on a particular book.
 * Type T is the product type.
 */
public class Trade<T> {
    T product;
    String tradeId;
    double price;
    String book;
    long quantity;
    Side side;

    private static long counter = 1;

    private String generateTradeId() {
        if (product instanceof Product) {
            ProductType type = ((Product) product).getProductType();
            String tradeId = type + this.book + String.format("%015d", counter);
            counter++;
            return tradeId;
        }
        return null;
    }

    public Trade(T product, double price, String book, long quantity, Side side) {
        this.product = product;
        this.book = book;
        this.tradeId = generateTradeId();
        this.price = price;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
