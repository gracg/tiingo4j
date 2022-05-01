package top.cptl.tiingo4j.enums;

public enum IEX_RESAMPLE_FREQUENCY {
    MINUTE("min"),
    HOUR("hour");

    private String value;
    IEX_RESAMPLE_FREQUENCY(String string){
        this.value=string;
    }

    @Override
    public String toString() {
        return value;
    }
}
