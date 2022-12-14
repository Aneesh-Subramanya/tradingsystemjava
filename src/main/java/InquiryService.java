package main.java;

import java.util.List;

/**
 * Service for customer inquirry objects.
 * Keyed on inquiry identifier (NOTE: this is NOT a product identifier since each inquiry must be unique).
 * Type T is the product type.
 */
public class InquiryService<T> extends Service<String, Inquiry<T>> {
    // Send a quote back to the client
    public void SendQuote(String inquiryId, double price) {

    }

    // Reject an inquiry from the client
    public void RejectInquiry(String inquiryId) {

    }

    @Override
    public Inquiry<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(Inquiry<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<Inquiry<T>> listener) {

    }

    @Override
    public List<ServiceListener<Inquiry<T>>> GetListeners() {
        return null;
    }
}
