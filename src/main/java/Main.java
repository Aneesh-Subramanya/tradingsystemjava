package main.java;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*MarketDataService<Bond> service = new MarketDataService<>();
        MarketDataConnector<Bond> marketDataConnector = new MarketDataConnector<Bond>();

        Thread t = new Thread(marketDataPublisher);
        t.start();
        Thread t2 = new Thread(marketDataConnector);
        t2.start();
        */

        // Socket publishers
        MarketDataPublisher marketDataPublisher = new MarketDataPublisher();
        TradeBookingServicePublisher tradeBookingServicePublisher = new TradeBookingServicePublisher();
        PricingServicePublisher pricingServicePublisher = new PricingServicePublisher();
        InquiryServicePublisher inquiryServicePublisher = new InquiryServicePublisher();

        // Socket subscribers
        ExecutionServiceSubscriber executionServiceSubscriber = new ExecutionServiceSubscriber();
        StreamingServiceSubscriber streamingServiceSubscriber = new StreamingServiceSubscriber();

        List<Connector<String>> threads = Arrays.asList(
                // Publishers
                marketDataPublisher,
                tradeBookingServicePublisher,
                pricingServicePublisher,
                inquiryServicePublisher,

                // Subscribers
                executionServiceSubscriber,
                streamingServiceSubscriber
        );

        for (var process : threads) {
            Thread thread = new Thread((Runnable) process);
            thread.start();
        }

        // Main services
        TradeBookingService<Bond> tradeBookingService = new TradeBookingService<>();
        PositionService<Bond> positionService = new PositionService<>();
        RiskService<Bond> riskService = new RiskService<>();
        GUIService<Bond> guiService = new GUIService<>();
        PricingService<Bond> pricingService = new PricingService<>();
        MarketDataService<Bond> marketDataService = new MarketDataService<>();
        ExecutionService<Bond> executionService = new ExecutionService<>();
        AlgoExecutionService<Bond> algoExecutionService = new AlgoExecutionService<>();
        AlgoStreamingService<Bond> algoStreamingService = new AlgoStreamingService<>();
        InquiryService<Bond> inquiryService = new InquiryService<>();
        StreamingService<Bond> streamingService = new StreamingService<>();

        // HistoricalData services
        HistoricalExecutionService<Bond> historicalExecutionService = new HistoricalExecutionService<>(new HistoricalExecutionServiceConnector<>());
        HistoricalInquiryService<Bond> historicalInquiryService = new HistoricalInquiryService<>(new HistoricalInquiryServiceConnector<>());
        HistoricalPositionService<Bond> historicalPositionService = new HistoricalPositionService<>(new HistoricalPositionServiceConnector<>());
        HistoricalRiskService<Bond> historicalRiskService = new HistoricalRiskService<>(new HistoricalRiskServiceConnector<>());
        HistoricalStreamingService<Bond> historicalStreamingService = new HistoricalStreamingService<>(new HistoricalStreamingServiceConnector<>());

        // Main service connectors
        MarketDataConnector<Bond> marketDataConnector = new MarketDataConnector<>();
        TradeBookingServiceConnector<Bond> tradeBookingServiceConnector = new TradeBookingServiceConnector<>(tradeBookingService);
        InquiryServiceConnector<Bond> inquiryServiceConnector = new InquiryServiceConnector<>(inquiryService);
        PricingServiceConnector<Bond> pricingServiceConnector = new PricingServiceConnector<>(pricingService);
        ExecutionServiceConnector<Bond> executionServiceConnector = new ExecutionServiceConnector<>();
        StreamingServiceConnector<Bond> streamingServiceConnector = new StreamingServiceConnector<>();
        GUIServiceConnector<Bond> guiServiceConnector = new GUIServiceConnector<>();

        // Main service listeners
        AlgoExecutionServiceListener<Bond> algoExecutionServiceListener = new AlgoExecutionServiceListener<>(algoExecutionService);
        AlgoStreamingServiceListener<Bond> algoStreamingServiceListener = new AlgoStreamingServiceListener<>(algoStreamingService);
        ExecutionServiceListener<Bond> executionServiceListener = new ExecutionServiceListener<>(executionService);
        InquiryServiceListener<Bond> inquiryServiceListener = new InquiryServiceListener<>(inquiryService);
        StreamingServiceListener<Bond> streamingServiceListener = new StreamingServiceListener<>(streamingService);
        TradeBookingServiceListener<Bond> tradeBookingServiceListener = new TradeBookingServiceListener<>(tradeBookingService);
        GUIServiceListener<Bond> guiServiceListener = new GUIServiceListener<>(guiService);
        PositionServiceListener<Bond> positionServiceListener = new PositionServiceListener<>(positionService);
        RiskServiceListener<Bond> riskServiceListener = new RiskServiceListener<>(riskService);

        // HistoricalData service listeners
        HistoricalExecutionServiceListener<Bond> historicalExecutionServiceListener = new HistoricalExecutionServiceListener<>(historicalExecutionService);
        HistoricalInquiryServiceListener<Bond> historicalInquiryServiceListener = new HistoricalInquiryServiceListener<>(historicalInquiryService);
        HistoricalPositionServiceListener<Bond> historicalPositionServiceListener = new HistoricalPositionServiceListener<>(historicalPositionService);
        HistoricalRiskServiceListener<Bond> historicalRiskServiceListener = new HistoricalRiskServiceListener<>(historicalRiskService);
        HistoricalStreamingServiceListener<Bond> historicalStreamingServiceListener = new HistoricalStreamingServiceListener<>(historicalStreamingService);

        // Add listeners to HistoricalData services
        executionService.AddListener(historicalExecutionServiceListener);
        inquiryService.AddListener(historicalInquiryServiceListener);
        positionService.AddListener(historicalPositionServiceListener);
        riskService.AddListener(historicalRiskServiceListener);
        streamingService.AddListener(historicalStreamingServiceListener);

        // Add listeners to the main services
        inquiryService.AddListener(inquiryServiceListener);
        pricingService.AddListener(guiServiceListener);
        pricingService.AddListener(algoStreamingServiceListener);
        algoStreamingService.AddListener(streamingServiceListener);
        executionService.AddListener(tradeBookingServiceListener);
        tradeBookingService.AddListener(positionServiceListener);
        positionService.AddListener(riskServiceListener);
        marketDataService.AddListener(algoExecutionServiceListener);
        algoExecutionService.AddListener(executionServiceListener);


        List<? extends Connector<?>> subscribers = Arrays.asList(
                // Main system subscribers
                marketDataConnector,
                tradeBookingServiceConnector,
                pricingServiceConnector,
                inquiryServiceConnector
        );

        for (var subscriber : subscribers) {
            Thread thread = new Thread((Runnable) subscriber);
            thread.start();
        }

        /*System.out.println(UtilFunctions.convertToBondPrice(99.0));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 1.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 2.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 3.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 4.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 5.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 6.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 7.0 / 256));
        System.out.println(UtilFunctions.convertToBondPrice(99.0 + 1.0 / 32 + 8.0 / 256));

        System.out.println(UtilFunctions.convertToDecimalPrice("99-000"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-010"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-011"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-012"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-013"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-01+"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-015"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-016"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-017"));
        System.out.println(UtilFunctions.convertToDecimalPrice("99-020"));

        Boolean bool = UtilFunctions.convertToDecimalPrice("99-000") == 99.0;
        bool &= UtilFunctions.convertToDecimalPrice("99-010") == 99.0 + 1.0 / 32;
        bool &= UtilFunctions.convertToDecimalPrice("99-011") == 99.0 + 1.0 / 32 + 1.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-012") == 99.0 + 1.0 / 32 + 2.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-013") == 99.0 + 1.0 / 32 + 3.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-01+") == 99.0 + 1.0 / 32 + 4.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-015") == 99.0 + 1.0 / 32 + 5.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-016") == 99.0 + 1.0 / 32 + 6.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-017") == 99.0 + 1.0 / 32 + 7.0 / 256;
        bool &= UtilFunctions.convertToDecimalPrice("99-020") == 99.0 + 1.0 / 32 + 8.0 / 256;
        System.out.println(bool);

        Bond bond = new Bond(UtilConstants.UST2y, BondIdType.CUSIP, "T", 0.0356, LocalDate.parse("2032-11-15"));
        System.out.println(bond instanceof Bond);

        List<Double> l = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0));
        Map<String, List<Double>> m = Map.of("asd", l);
        System.out.println(l);
        System.out.println(m);
        l.add(4.0);
        System.out.println(l);
        System.out.println(m);
        l = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        System.out.println(l);
        System.out.println(m);
        l.clear();
        System.out.println(l);
        System.out.println(m);*/
    }
}
