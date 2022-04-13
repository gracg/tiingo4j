package nl.capite.tiingo4j.models;

import lombok.Data;

import java.util.Map;

@Data
public class CryptoPrice {
    private String ticker;
    private String baseCurrency;
    private String quoteCurrency;
    private CryptoPriceData[] priceData;
    private Map<String, CryptoExchangeData[]> exchangeData;
}
