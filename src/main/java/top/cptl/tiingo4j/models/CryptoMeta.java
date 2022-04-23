package top.cptl.tiingo4j.models;

import lombok.Data;

@Data
public class CryptoMeta {
    private String ticker;
    private String baseCurrency;
    private String quoteCurrency;
    private String name;
    private String description;
}
