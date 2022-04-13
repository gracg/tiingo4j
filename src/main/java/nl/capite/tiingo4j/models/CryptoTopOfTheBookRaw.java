package nl.capite.tiingo4j.models;

import lombok.Data;

import java.util.Map;

@Data
public class CryptoTopOfTheBookRaw extends CryptoTopOfTheBook{
    private Map<String,CryptoTopOfTheBookData[]> exchangeData;
}
