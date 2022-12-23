package main.java;

import main.enums.InquiryState;

public class InquiryServiceConnector<T> extends Connector<Inquiry<T>> {
    private InquiryService<T> service;

    public InquiryServiceConnector(InquiryService<T> service) {
        this.service = service;
    }

    public InquiryService<T> getService() {
        return service;
    }

    public void setService(InquiryService<T> service) {
        this.service = service;
    }

    @Override
    public void Publish(Inquiry<T> data) {
        if (data.getState() == InquiryState.RECEIVED) {
            double price = data.getPrice();
            data.setState(InquiryState.QUOTED);
            service.OnMessage(data);
            data.setState(InquiryState.DONE);
            service.OnMessage(data);
        }
    }
}
