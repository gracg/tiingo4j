package nl.capite.tiingo4j.models;

import lombok.Data;

@Data
public class Price {
    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Integer volume;
    private Double adjOpen;
    private Double adjHigh;
    private Double adjLow;
    private Double adjClose;
    private Integer adjVolume;
    private Double divCash;
    private Double splitFactor;
}
