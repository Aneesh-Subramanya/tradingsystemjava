package main.java;

import main.enums.InquiryState;

import java.util.List;
import java.util.Map;

/**
 * Service for customer inquiry objects.
 * Keyed on inquiry identifier (NOTE: this is NOT a product identifier since each inquiry must be unique).
 * Type T is the product type.
 */
public class InquiryService<T> extends Service<String, Inquiry<T>> {
    private Map<String, Inquiry<T>> inquiryMap;
    private List<ServiceListener<Inquiry<T>>> listeners;
    private InquiryServiceConnector<T> connector;


    public InquiryService(Map<String, Inquiry<T>> inquiryMap, List<ServiceListener<Inquiry<T>>> listeners, InquiryServiceConnector<T> connector) {
        this.inquiryMap = inquiryMap;
        this.listeners = listeners;
        this.connector = connector;
    }

    public Map<String, Inquiry<T>> getInquiryMap() {
        return inquiryMap;
    }

    public void setInquiryMap(Map<String, Inquiry<T>> inquiryMap) {
        this.inquiryMap = inquiryMap;
    }

    public List<ServiceListener<Inquiry<T>>> getListeners() {
        return listeners;
    }

    public void setListeners(List<ServiceListener<Inquiry<T>>> listeners) {
        this.listeners = listeners;
    }

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
                // For now, do nothing.
                break;
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
