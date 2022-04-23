package top.cptl.tiingo4j.enums;

public enum CRYPTO_RESAMPLE_FREQUENCY {
    MINUTE("min"),
    HOUR("hour"),
    DAY("day");

    private String value;

    CRYPTO_RESAMPLE_FREQUENCY(String string) {
        value = string;
    }

    @Override
    public String toString() {
        return value;

    }
}
