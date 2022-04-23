package top.cptl.tiingo4j.enums;

public enum RESAMPLE_FREQUENCY {
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    ANNUALLY("annually");

    private String value;
    RESAMPLE_FREQUENCY(String string){
        this.value=string;
    }

    @Override
    public String toString() {
        return value;
    }
}
