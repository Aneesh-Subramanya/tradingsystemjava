package main.java;

import java.util.List;

/**
 * Service for customer inquirry objects.
 * Keyed on inquiry identifier (NOTE: this is NOT a product identifier since each inquiry must be unique).
 * Type T is the product type.
 */
public class InquiryService<T> extends Service<String, T> {
    // Send a quote back to the client
    public void SendQuote(String inquiryId, double price) {

    }

    // Reject an inquiry from the client
    public void RejectInquiry(String inquiryId) {

    }

    @Override
    public T GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(T data) {

    }

    @Override
    public void AddListener(ServiceListener<T> listener) {

    }

    @Override
    public List<ServiceListener<T>> GetListeners() {
        return null;
    }
}
