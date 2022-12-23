package main.java;

public class HistoricalInquiryServiceListener<T> extends ServiceListener<Inquiry<T>> {

    HistoricalinquiryService<T> service;

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
