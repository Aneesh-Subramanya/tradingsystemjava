package main.enums;

public enum SwapType {
    STANDARD,
    FORWARD,
    IMM,
    MAC,
    BASIS;

    @Override
    public String toString() {
        switch (this) {
            case STANDARD:
                return "Standard";
            case FORWARD:
                return "Forward";
            case IMM:
                return "IMM";
            case MAC:
                return "MAC";
            case BASIS:
                return "Basis";
            default:
                return "";
        }
    }
}
