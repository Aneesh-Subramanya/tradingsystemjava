package main.java;

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

    }
}
