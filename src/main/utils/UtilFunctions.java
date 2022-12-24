package main.utils;

import main.constants.UtilConstants;
import main.enums.PricingSide;
import main.enums.Side;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class UtilFunctions {
    public static String convertToBondPrice(Double decimalPrice) {
        if (decimalPrice == null) {
            return "";
        }

        int pct = (int) Math.floor(decimalPrice);
        String PCT = String.valueOf(pct);

        double fraction = decimalPrice - pct;
        int xy = (int) Math.floor(fraction / UtilConstants.ONE_32);
        String XY = String.format("%02d", xy);

        int z = (int) Math.floor((fraction - xy * UtilConstants.ONE_32) / UtilConstants.ONE_256);
        String Z = z == 4 ? "+" : String.valueOf(z);

        return PCT + "-" + XY + Z;
    }

    public static double convertToDecimalPrice(String bondPrice) {
        String[] parts = bondPrice.split("-");
        String PCT = parts[0];
        String XY = parts[1].substring(0, 2);
        String Z = parts[1].substring(2, 3);

        double pct = Double.parseDouble(PCT);
        double xy = Double.parseDouble(XY) * UtilConstants.ONE_32;
        double z = (Z.equals("+") ? 4.0 : Double.parseDouble(Z)) * UtilConstants.ONE_256;

        return pct + xy + z;
    }

    public static double pctToUnit(double pct) {
        return pct / 100.0;
    }

    public static double unitToPct(double unit) {
        return unit * 100.0;
    }

    public static Side getTradeSide(PricingSide side) {
        switch (side) {
            case BID:
                return Side.BUY;
            case OFFER:
                return Side.SELL;
        }
        return null;
    }

    public static void clearOutputFiles() {
        List<String> outputFiles = Arrays.asList(
                UtilConstants.HISTORICAL_EXECUTIONS_FILE,
                UtilConstants.HISTORICAL_ALLINQUIRIES_FILE,
                UtilConstants.HISTORICAL_POSITIONS_FILE,
                UtilConstants.HISTORICAL_RISK_FILE,
                UtilConstants.HISTORICAL_STREAMING_FILE,
                UtilConstants.GUIFILE,
                UtilConstants.EXECUTIONSERVICEFILE,
                UtilConstants.STREAMINGSERVICEFILE
        );

        for (String outputFile : outputFiles) {
            try {
                Files.deleteIfExists(Path.of(outputFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
