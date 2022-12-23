package main.java;

public class GUIServiceListener<T> extends ServiceListener<Price<T>> {
    GUIService<T> guiService;

    public GUIServiceListener(GUIService<T> guiService) {
        this.guiService = guiService;
    }

    public GUIService<T> getInquiryService() {
        return guiService;
    }

    public void setInquiryService(GUIService<T> inquiryService) {
        this.guiService = inquiryService;
    }

    @Override
    public void ProcessAdd(Price<T> data) {
        guiService.OnMessage(data);
    }

    @Override
    public void ProcessUpdate(Price<T> data) {

    }

    @Override
    public void ProcessRemove(Price<T> data) {

    }
}
