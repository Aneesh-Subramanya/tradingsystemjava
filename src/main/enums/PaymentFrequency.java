package main.enums;

public enum PaymentFrequency {
    QUARTERLY,
    SEMI_ANNUAL,
    ANNUAL;

    @Override
    public String toString() {
        switch (this) {
            case QUARTERLY:
                return "Quarterly";
            case SEMI_ANNUAL:
                return "Semi-Annual";
            case ANNUAL:
                return "Annual";
            default:
                return "";
        }
    }
}
