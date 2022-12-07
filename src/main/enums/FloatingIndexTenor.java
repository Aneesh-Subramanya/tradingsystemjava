package main.enums;

public enum FloatingIndexTenor {
    TENOR_1M,
    TENOR_3M,
    TENOR_6M,
    TENOR_12M;

    @Override
    public String toString() {
        switch (this) {
            case TENOR_1M:
                return "1m";
            case TENOR_3M:
                return "3m";
            case TENOR_6M:
                return "6m";
            case TENOR_12M:
                return "12m";
            default:
                return "";
        }
    }
}
