package main.java.histlisteners;

import main.java.entities.Inquiry;
import main.java.histservices.HistoricalInquiryService;
import main.java.listeners.ServiceListener;

public class HistoricalInquiryServiceListener<T> extends ServiceListener<Inquiry<T>> {
    HistoricalInquiryService<T> service;

    public HistoricalInquiryServiceListener(HistoricalInquiryService<T> service) {
        this.service = service;
    }

    @Override
    public void ProcessAdd(Inquiry<T> data) {
        service.PersistData(data.getInquiryId(), data);
    }

    @Override
    public void ProcessRemove(Inquiry<T> data) {

    }

    @Override
    public void ProcessUpdate(Inquiry<T> data) {
        service.PersistData(data.getInquiryId(), data);
    }
}
