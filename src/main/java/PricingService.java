package main.java;

/**
 * Pricing Service managing mid prices and bid/offers.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class PricingService<T> extends Service<String, Price<T>> {
}
