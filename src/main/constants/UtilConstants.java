package main.constants;

import java.util.Arrays;
import java.util.List;

public class UtilConstants {
    // USTs
    public static final String UST2y = "TMUBMUSD02Y";
    public static final String UST3y = "TMUBMUSD03Y";
    public static final String UST5y = "TMUBMUSD05Y";
    public static final String UST7y = "TMUBMUSD07Y";
    public static final String UST10y = "TMUBMUSD10Y";
    public static final String UST20y = "TMUBMUSD20Y";
    public static final String UST30y = "TMUBMUSD30Y";

    // Trading Books
    public static final List<String> BOOKS = Arrays.asList("TRSY1", "TRSY2", "TRSY3");

    // Doubles
    public static final double ONE_32 = 1.0 / 32.0;
    public static final double ONE_128 = 1.0 / 128.0;
    public static final double ONE_256 = 1.0 / 256.0;

    // Quote price - Constant for now but it should ideally come from a trader.
    public static final double TRADER_QUOTE_PRICE = 100.0;

    // File names
    public static final String MARKETDATAFILE = "support/marketdata.txt";
    public static final int MARKETDATAPORT = 59091;
    public static final String MARKETDATAURL = "127.0.0.1";

    public static final String PRICINGSERVICEFILE = "support/prices.txt";
    public static final int PRICINGSERVICEPORT = 59092;
    public static final String PRICINGSERVICEURL = "127.0.0.2";

    public static final String BOOKINGSERVICEFILE = "support/trades.txt";
    public static final int BOOKINGSERVICEPORT = 59093;
    public static final String BOOKINGSERVICEURL = "127.0.0.3";

    public static final String INQUIRYSERVICEFILE = "support/inquiries.txt";
    public static final int INQUIRYSERVICEPORT = 59094;
    public static final String INQUIRYSERVICEURL = "127.0.0.4";

    public static final String EXECUTIONSERVICEFILE = "support/executions.txt";
    public static final int EXECUTIONSERVICEPORT = 59095;
    public static final String EXECUTIONSERVICEURL = "127.0.0.5";

    public static final String STREAMINGSERVICEFILE = "support/streaming.txt";
    public static final int STREAMINGSERVICEPORT = 59096;
    public static final String STREAMINGSERVICEURL = "127.0.0.6";

    // GUIService
    public static final int UPDATES_TO_PRINT = 100;
    public static final String GUIFILE = "support/gui.txt";

}
