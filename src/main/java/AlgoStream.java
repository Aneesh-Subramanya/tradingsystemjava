package main.java;

public class AlgoStream<T> {
    private PriceStream<T> priceStream;

    public AlgoStream(PriceStream<T> priceStream) {
        this.priceStream = priceStream;
    }

    public PriceStream<T> getPriceStream() {
        return priceStream;
    }

    public void setPriceStream(PriceStream<T> priceStream) {
        this.priceStream = priceStream;
    }
}
