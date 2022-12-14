package main.java;

import java.util.List;

/**
 * Service for customer inquirry objects.
 * Keyed on inquiry identifier (NOTE: this is NOT a product identifier since each inquiry must be unique).
 * Type T is the product type.
 */
public abstract class InquiryService<T> extends Service<String, Inquiry<T>> {
    // Send a quote back to the client
    public abstract void SendQuote(String inquiryId, double price);

    // Reject an inquiry from the client
    public abstract void RejectInquiry(String inquiryId);
}
