package main.constants;

import java.util.Arrays;
import java.util.List;

public class UtilConstants {
    // USTs
    public static final String UST2y = "91282CFX4";
    public static final String UST3y = "91282CGA3";
    public static final String UST5y = "91282CFZ9";
    public static final String UST7y = "91282CFY2";
    public static final String UST10y = "91282CFV8";
    public static final String UST20y = "912810TM0";
    public static final String UST30y = "912810TL2";

    public static final String FRONTEND_BUCKET = "FrontEnd";
    public static final String BELLY_BUCKET = "Belly";
    public static final String LONGEND_BUCKET = "LongEnd";

    public static final List<String> FRONTEND_TENORS = Arrays.asList(UST2y, UST3y);
    public static final List<String> BELLY_TENORS = Arrays.asList(UST5y, UST7y, UST10y);
    public static final List<String> LONGEND_TENORS = Arrays.asList(UST20y, UST30y);

    // Trading Books
    public static final List<String> BOOKS = Arrays.asList("TRSY1", "TRSY2", "TRSY3");

    // Doubles
    public static final double ONE_32 = 1.0 / 32.0;
    public static final double ONE_128 = 1.0 / 128.0;
    public static final double ONE_256 = 1.0 / 256.0;

    // Quote price - Constant for now but it should ideally come from a trader.
    public static final double TRADER_QUOTE_PRICE = 100.0;

    // File names
    public static final String MARKETDATAFILE = "test/inputFiles/marketdata.txt";
    public static final int MARKETDATAPORT = 59091;
    public static final String MARKETDATAURL = "127.0.0.1";

    public static final String PRICINGSERVICEFILE = "test/inputFiles/prices.txt";
    public static final int PRICINGSERVICEPORT = 59092;
    public static final String PRICINGSERVICEURL = "127.0.0.2";

    public static final String BOOKINGSERVICEFILE = "test/inputFiles/trades.txt";
    public static final int BOOKINGSERVICEPORT = 59093;
    public static final String BOOKINGSERVICEURL = "127.0.0.3";

    public static final String INQUIRYSERVICEFILE = "test/inputFiles/inquiries.txt";
    public static final int INQUIRYSERVICEPORT = 59094;
    public static final String INQUIRYSERVICEURL = "127.0.0.4";

    public static final String EXECUTIONSERVICEFILE = "test/live/executionslive.txt";
    public static final int EXECUTIONSERVICEPORT = 59095;
    public static final String EXECUTIONSERVICEURL = "127.0.0.5";

    public static final String STREAMINGSERVICEFILE = "test/live/streaming.txt";
    public static final int STREAMINGSERVICEPORT = 59096;
    public static final String STREAMINGSERVICEURL = "127.0.0.6";

    // GUIService
    public static final int UPDATES_TO_PRINT = 100;
    public static final String GUIFILE = "test/live/gui.txt";

    // HistoricalData files
    public static final String HISTORICAL_EXECUTIONS_FILE = "test/historical/executions.txt";
    public static final String HISTORICAL_ALLINQUIRIES_FILE = "test/historical/allinquiries.txt";
    public static final String HISTORICAL_POSITIONS_FILE = "test/historical/positions.txt";
    public static final String HISTORICAL_RISK_FILE = "test/historical/risk.txt";
    public static final String HISTORICAL_STREAMING_FILE = "test/historical/streaming.txt";
}
