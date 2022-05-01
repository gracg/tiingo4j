package top.cptl.tiingo4j.models;

import lombok.Data;

@Data
public class IexPrice {
    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
}
