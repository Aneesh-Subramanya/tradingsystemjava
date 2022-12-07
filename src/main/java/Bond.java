package main.java;

import main.enums.BondIdType;
import main.enums.ProductType;

import java.util.Date;

/**
 * Bond product class
 */
public class Bond extends Product {
    private BondIdType bondIdType; // bond id type variable
    private String ticker;         // ticker variable
    private float coupon;          // coupon variable
    private Date maturityDate;     // maturity date variable


    public Bond(String productId) {
        super(productId, ProductType.BOND);
    }

    public Bond(String productId, BondIdType bondIdType, String ticker, float coupon, Date maturityDate) {
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

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "bondIdType=" + bondIdType +
                ", ticker='" + ticker + '\'' +
                ", coupon=" + coupon +
                ", maturityDate=" + maturityDate +
                ", productId='" + productId + '\'' +
                ", productType=" + productType +
                '}';
    }
}
