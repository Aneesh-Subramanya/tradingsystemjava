package main.java.products;

import main.constants.UtilConstants;
import main.enums.BondIdType;
import main.enums.ProductType;
import main.utils.UtilFunctions;

import java.time.LocalDate;

import static main.enums.BondIdType.CUSIP;

/**
 * Bond product class
 */
public class Bond extends Product {
    private BondIdType bondIdType; // bond id type variable
    private String ticker;         // ticker variable
    private Double coupon;          // coupon variable
    private LocalDate maturityDate;     // maturity date variable


    public Bond(String productId) {
        super(productId, ProductType.BOND);
    }

    public Bond(String productId, BondIdType bondIdType, String ticker, double coupon, LocalDate maturityDate) {
        super(productId, ProductType.BOND);

        this.bondIdType = bondIdType;
        this.ticker = ticker;
        this.coupon = coupon;
        this.maturityDate = maturityDate;
    }

    public BondIdType getBondIdType() {
        return bondIdType;
    }

    public void setBondIdType(BondIdType bondIdType) {
        this.bondIdType = bondIdType;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public static Bond GetBond(String cusip) {
        switch (cusip) {
            case UtilConstants.UST2y:
                return new Bond(UtilConstants.UST2y, CUSIP, "T", UtilFunctions.pctToUnit(4.264), LocalDate.parse("2024-11-30"));
            case UtilConstants.UST3y:
                return new Bond(UtilConstants.UST3y, CUSIP, "T", UtilFunctions.pctToUnit(3.958), LocalDate.parse("2025-12-15"));
            case UtilConstants.UST5y:
                return new Bond(UtilConstants.UST5y, CUSIP, "T", UtilFunctions.pctToUnit(3.659), LocalDate.parse("2027-11-30"));
            case UtilConstants.UST7y:
                return new Bond(UtilConstants.UST7y, CUSIP, "T", UtilFunctions.pctToUnit(3.610), LocalDate.parse("2029-11-30"));
            case UtilConstants.UST10y:
                return new Bond(UtilConstants.UST10y, CUSIP, "T", UtilFunctions.pctToUnit(3.511), LocalDate.parse("2032-11-15"));
            case UtilConstants.UST20y:
                return new Bond(UtilConstants.UST20y, CUSIP, "T", UtilFunctions.pctToUnit(3.756), LocalDate.parse("2042-11-15"));
            case UtilConstants.UST30y:
                return new Bond(UtilConstants.UST30y, CUSIP, "T", UtilFunctions.pctToUnit(3.556), LocalDate.parse("2052-11-15"));
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Bond{" +
                "bondIdType=" + bondIdType +
                ", ticker='" + ticker + '\'' +
                ", coupon=" + (coupon == null ? "" : String.format("%.4f", UtilFunctions.unitToPct(coupon))) +
                ", maturityDate=" + maturityDate +
                ", productId='" + productId + '\'' +
                ", productType=" + productType +
                '}';
    }
}
