package main.java;

import main.constants.UtilConstants;
import main.enums.InquiryState;

public class InquiryServiceListener<T> extends ServiceListener<Inquiry<T>> {
    InquiryService<T> inquiryService;

    public InquiryServiceListener(InquiryService<T> inquiryService) {
        this.inquiryService = inquiryService;
    }

    public InquiryService<T> getInquiryService() {
        return inquiryService;
    }

    public void setInquiryService(InquiryService<T> inquiryService) {
        this.inquiryService = inquiryService;
    }

    @Override
    public void ProcessAdd(Inquiry<T> data) {
        inquiryService.sendQuote(data.getInquiryId(), UtilConstants.TRADER_QUOTE_PRICE);
    }

    @Override
    public void ProcessUpdate(Inquiry<T> data) {
        inquiryService.sendQuote(data.getInquiryId(), InquiryState.DONE);
    }

    @Override
    public void ProcessRemove(Inquiry<T> data) {

    }
}
