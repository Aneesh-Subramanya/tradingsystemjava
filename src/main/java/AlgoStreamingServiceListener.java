package main.java;

public class AlgoStreamingServiceListener<T> extends ServiceListener<Price<T>> {
    private AlgoStreamingService<T> algoStreamingService;

    public AlgoStreamingServiceListener(AlgoStreamingService<T> algoStreamingService) {
        this.algoStreamingService = algoStreamingService;
    }

    public AlgoStreamingService<T> getAlgoStreamingService() {
        return algoStreamingService;
    }

    public void setAlgoStreamingService(AlgoStreamingService<T> algoStreamingService) {
        this.algoStreamingService = algoStreamingService;
    }

    @Override
    public void ProcessAdd(Price<T> data) {
        algoStreamingService.addStream(data);
    }

    @Override
    public void ProcessRemove(Price<T> data) {

    }

    @Override
    public void ProcessUpdate(Price<T> data) {

    }
}
