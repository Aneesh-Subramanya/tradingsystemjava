package main.java.listeners;

import main.java.entities.AlgoStream;
import main.java.entities.PriceStream;
import main.java.services.StreamingService;

public class StreamingServiceListener<T> extends ServiceListener<AlgoStream<T>> {
    private StreamingService<T> streamingService;

    public StreamingServiceListener(StreamingService<T> streamingService) {
        this.streamingService = streamingService;
    }

    public StreamingService<T> getStreamingService() {
        return streamingService;
    }

    public void setStreamingService(StreamingService<T> streamingService) {
        this.streamingService = streamingService;
    }

    @Override
    public void ProcessAdd(AlgoStream<T> data) {
        PriceStream<T> priceStream = data.getPriceStream();
        streamingService.PublishPrice(priceStream);
    }

    @Override
    public void ProcessRemove(AlgoStream<T> data) {

    }

    @Override
    public void ProcessUpdate(AlgoStream<T> data) {

    }
}
