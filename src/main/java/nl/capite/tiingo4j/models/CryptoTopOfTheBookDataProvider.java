package nl.capite.tiingo4j.models;

import kotlin.jvm.internal.PropertyReference0Impl;
import lombok.Data;

@Data
public class CryptoTopOfTheBookDataProvider {
    private Double bidSize;
    private String quoteTimestampStr;
    private String exchangeCode;
    private Double lastSize;
    private Double bidPrice;
    private Double lastPrice;
    private String lastSaleTimestampStr;
    private Double askPrice;
    private Double askSize;
}
