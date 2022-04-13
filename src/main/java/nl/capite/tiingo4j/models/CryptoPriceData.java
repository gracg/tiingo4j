package nl.capite.tiingo4j.models;

import lombok.Data;

@Data
public class CryptoPriceData {
    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double tradesDone;
    private Double volume;
    private Double volumeNotional;
    private Double lastSizeNotional;
}
