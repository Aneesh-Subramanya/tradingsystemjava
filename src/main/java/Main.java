package main.java;

import main.constants.UtilConstants;
import main.enums.BondIdType;
import main.utils.UtilFunctions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(UtilFunctions.convertToBondPrice(99.0));
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
        System.out.println(m);
    }
}
