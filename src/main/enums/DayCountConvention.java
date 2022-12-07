package main.enums;

public enum DayCountConvention {
    THIRTY_THREE_SIXTY,
    ACT_THREE_SIXTY;

    @Override
    public String toString() {
        switch (this) {
            case THIRTY_THREE_SIXTY:
                return "30/360";
            case ACT_THREE_SIXTY:
                return "Act/360";
            default:
                return "";
        }
    }
}
