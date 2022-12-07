package main.java;

import main.enums.ProductType;

/**
 * Base class for a product.
 */
public abstract class Product {
    protected String productId;
    protected ProductType productType;

    public Product() {
    }

    public Product(String productId, ProductType productType) {
        this.productId = productId;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
