package main.java;

import main.java.connectors.*;
import main.java.histconnectors.*;
import main.java.histlisteners.*;
import main.java.histservices.*;
import main.java.listeners.*;
import main.java.products.Bond;
import main.java.publishers.InquiryServicePublisher;
import main.java.publishers.MarketDataPublisher;
import main.java.publishers.PricingServicePublisher;
import main.java.publishers.TradeBookingServicePublisher;
import main.java.services.*;
import main.java.subscribers.ExecutionServiceSubscriber;
import main.java.subscribers.StreamingServiceSubscriber;
import main.utils.UtilFunctions;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Clear all output files before a fresh run
        UtilFunctions.clearOutputFiles();

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
        MarketDataConnector<Bond> marketDataConnector = new MarketDataConnector<>(marketDataService);
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

    }
}
