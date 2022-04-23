package top.cptl.tiingo4j.models;

import lombok.Data;

@Data
public class CryptoTopOfTheBookData {
    private String quoteTimestamp;
    private String lastSaleTimestamp;
    private Double lastPrice;
    private Double lastSize;
    private Double lastSizeNotional;
    private String lastExchange;
    private Double bidSize;
    private Double bidPrice;
    private String bidExchange;
    private Double askSize;
    private Double askPrice;
    private String askExchange;
}
