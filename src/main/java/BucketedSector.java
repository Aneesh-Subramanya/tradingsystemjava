package main.java;

import java.util.List;

/**
 * A bucket sector to bucket a group of securities.
 * We can then aggregate bucketed risk to this bucket.
 * Type T is the product type.
 */
public class BucketedSector<T> {
    List<T> products;
    String name;

    public BucketedSector(List<T> products, String name) {
        this.products = products;
        this.name = name;
    }

    public List<T> getProducts() {
        return products;
    }

    public void setProducts(List<T> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
