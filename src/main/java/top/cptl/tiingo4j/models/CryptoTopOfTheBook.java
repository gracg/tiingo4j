package top.cptl.tiingo4j.models;

import lombok.Data;

import java.util.Map;

@Data
public class CryptoTopOfTheBook {
    private String ticker;
    private String baseCurrency;
    private String quoteCurrency;
    private CryptoTopOfTheBookData[] topOfBookData;
    private Map<String, CryptoExchangeData[]> exchangeData;
}
