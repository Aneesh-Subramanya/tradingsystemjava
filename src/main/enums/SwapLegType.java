package main.enums;

public enum SwapLegType {
    OUTRIGHT,
    CURVE,
    FLY;

    @Override
    public String toString() {
        switch (this) {
            case OUTRIGHT:
                return "Outright";
            case CURVE:
                return "Curve";
            case FLY:
                return "Fly";
            default:
                return "";
        }
    }
}
