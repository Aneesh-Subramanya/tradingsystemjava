package main.java.products;

import main.enums.*;

import java.util.Date;

/**
 * Interest Rate Swap product
 */
public class IRSwap extends Product {
    private DayCountConvention fixedLegDayCountConvention;    // fixed leg daycount convention variable
    private DayCountConvention floatingLegDayCountConvention; // floating leg daycount convention variable
    private PaymentFrequency fixedLegPaymentFrequency;        // fixed leg payment freq
    private FloatingIndex floatingIndex;                      // floating leg index
    private FloatingIndexTenor floatingIndexTenor;            // floating leg tenor
    private Date effectiveDate;                               // effective date
    private Date terminationDate;                             // termination date
    private Currency currency;                                // currency
    private int termYears;                                    // term in years
    private SwapType swapType;                                // swap type
    private SwapLegType swapLegType;                          // swap leg type

    public IRSwap(String productId) {
        super(productId, ProductType.IRSWAP);
    }

    public IRSwap(String productId, DayCountConvention fixedLegDayCountConvention, DayCountConvention floatingLegDayCountConvention, PaymentFrequency fixedLegPaymentFrequency, FloatingIndex floatingIndex, FloatingIndexTenor floatingIndexTenor, Date effectiveDate, Date terminationDate, Currency currency, int termYears, SwapType swapType, SwapLegType swapLegType) {
        super(productId, ProductType.IRSWAP);

        this.fixedLegDayCountConvention = fixedLegDayCountConvention;
        this.floatingLegDayCountConvention = floatingLegDayCountConvention;
        this.fixedLegPaymentFrequency = fixedLegPaymentFrequency;
        this.floatingIndex = floatingIndex;
        this.floatingIndexTenor = floatingIndexTenor;
        this.effectiveDate = effectiveDate;
        this.terminationDate = terminationDate;
        this.currency = currency;
        this.termYears = termYears;
        this.swapType = swapType;
        this.swapLegType = swapLegType;
    }

    public DayCountConvention getFixedLegDayCountConvention() {
        return fixedLegDayCountConvention;
    }

    public void setFixedLegDayCountConvention(DayCountConvention fixedLegDayCountConvention) {
        this.fixedLegDayCountConvention = fixedLegDayCountConvention;
    }

    public DayCountConvention getFloatingLegDayCountConvention() {
        return floatingLegDayCountConvention;
    }

    public void setFloatingLegDayCountConvention(DayCountConvention floatingLegDayCountConvention) {
        this.floatingLegDayCountConvention = floatingLegDayCountConvention;
    }

    public PaymentFrequency getFixedLegPaymentFrequency() {
        return fixedLegPaymentFrequency;
    }

    public void setFixedLegPaymentFrequency(PaymentFrequency fixedLegPaymentFrequency) {
        this.fixedLegPaymentFrequency = fixedLegPaymentFrequency;
    }

    public FloatingIndex getFloatingIndex() {
        return floatingIndex;
    }

    public void setFloatingIndex(FloatingIndex floatingIndex) {
        this.floatingIndex = floatingIndex;
    }

    public FloatingIndexTenor getFloatingIndexTenor() {
        return floatingIndexTenor;
    }

    public void setFloatingIndexTenor(FloatingIndexTenor floatingIndexTenor) {
        this.floatingIndexTenor = floatingIndexTenor;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }

    public SwapType getSwapType() {
        return swapType;
    }

    public void setSwapType(SwapType swapType) {
        this.swapType = swapType;
    }

    public SwapLegType getSwapLegType() {
        return swapLegType;
    }

    public void setSwapLegType(SwapLegType swapLegType) {
        this.swapLegType = swapLegType;
    }

    @Override
    public String toString() {
        return "IRSwap{" +
                "fixedLegDayCountConvention=" + fixedLegDayCountConvention +
                ", floatingLegDayCountConvention=" + floatingLegDayCountConvention +
                ", fixedLegPaymentFrequency=" + fixedLegPaymentFrequency +
                ", floatingIndex=" + floatingIndex +
                ", floatingIndexTenor=" + floatingIndexTenor +
                ", effectiveDate=" + effectiveDate +
                ", terminationDate=" + terminationDate +
                ", currency=" + currency +
                ", termYears=" + termYears +
                ", swapType=" + swapType +
                ", swapLegType=" + swapLegType +
                ", productId='" + productId + '\'' +
                ", productType=" + productType +
                '}';
    }
}
