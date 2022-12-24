package main.java.products;

import main.enums.Currency;

import java.util.Date;

public class Future extends Product {
    private String productId;       // product identifier variable
    private String ticker;          // ticker variable
    private String underlyingAsset; // underlyingAsset variable
    private int contractSize;       // contractSize variable
    private Date maturityDate;      // maturity date variable
    private Currency currency;      // Denominated currency

    public Future(String productId, String ticker, String underlyingAsset, int contractSize, Date maturityDate, Currency currency) {
        this.productId = productId;
        this.ticker = ticker;
        this.underlyingAsset = underlyingAsset;
        this.contractSize = contractSize;
        this.maturityDate = maturityDate;
        this.currency = currency;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getUnderlyingAsset() {
        return underlyingAsset;
    }

    public void setUnderlyingAsset(String underlyingAsset) {
        this.underlyingAsset = underlyingAsset;
    }

    public int getContractSize() {
        return contractSize;
    }

    public void setContractSize(int contractSize) {
        this.contractSize = contractSize;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Future{" +
                "productId='" + productId + '\'' +
                ", ticker='" + ticker + '\'' +
                ", underlyingAsset='" + underlyingAsset + '\'' +
                ", contractSize=" + contractSize +
                ", maturityDate=" + maturityDate +
                ", currency=" + currency +
                '}';
    }
}
