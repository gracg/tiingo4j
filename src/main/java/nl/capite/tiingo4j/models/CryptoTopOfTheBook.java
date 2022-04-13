package nl.capite.tiingo4j.models;

import lombok.Data;

@Data
public class CryptoTopOfTheBook {
    protected String ticker;
    protected String baseCurrency;
    protected String quoteCurrency;
    protected CryptoTopOfTheBookData[] topOfBookData;
}
