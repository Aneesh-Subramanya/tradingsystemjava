package main.java.services;

import main.enums.InquiryState;
import main.java.connectors.InquiryServiceConnector;
import main.java.entities.Inquiry;
import main.java.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for customer inquiry objects.
 * Keyed on inquiry identifier (NOTE: this is NOT a product identifier since each inquiry must be unique).
 * Type T is the product type.
 */
public class InquiryService<T> extends Service<String, Inquiry<T>> {
    private final Map<String, Inquiry<T>> inquiryMap = new HashMap<>();
    private final List<ServiceListener<Inquiry<T>>> listeners = new ArrayList<>();
    private InquiryServiceConnector<T> connector = new InquiryServiceConnector<>(this);

    public InquiryServiceConnector<T> getConnector() {
        return connector;
    }

    public void setConnector(InquiryServiceConnector<T> connector) {
        this.connector = connector;
    }

    // Send a quote back to the client
    public void SendQuote(String inquiryId, double price) {

    }

    // Reject an inquiry from the client
    public void RejectInquiry(String inquiryId) {

    }

    @Override
    public Inquiry<T> GetData(String key) {
        return inquiryMap.get(key);
    }

    @Override
    public void OnMessage(Inquiry<T> data) {
        String inquiryId = data.getInquiryId();
        InquiryState inquiryState = data.getState();

        switch (inquiryState) {
            case RECEIVED:
                inquiryMap.put(inquiryId, data);
                for (ServiceListener<Inquiry<T>> listener : listeners) {
                    listener.ProcessAdd(data);
                }
                break;
            case QUOTED:
            case DONE:
                for (ServiceListener<Inquiry<T>> listener : listeners) {
                    listener.ProcessUpdate(data);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void AddListener(ServiceListener<Inquiry<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<Inquiry<T>>> GetListeners() {
        return listeners;
    }

    public void sendQuote(String inquiryId, double price) {
        Inquiry<T> inquiry = GetData(inquiryId);
        if (inquiry != null) {
            inquiry.setPrice(price);
            connector.Publish(inquiry);
        }
    }

    public void sendQuote(String inquiryId, InquiryState state) {
        Inquiry<T> inquiry = GetData(inquiryId);
        if (inquiry != null && inquiry.getState() != state) {
            inquiry.setState(state);
        }
    }
}
