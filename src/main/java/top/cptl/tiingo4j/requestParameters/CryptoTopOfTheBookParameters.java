package top.cptl.tiingo4j.requestParameters;

import top.cptl.tiingo4j.abstracts.AbstractParameters;

import java.util.List;

public class CryptoTopOfTheBookParameters extends AbstractParameters {



    public CryptoTopOfTheBookParameters setExchanges(List<String> exchanges) {
        if(exchanges!=null && exchanges.size()>0) {
            map.put("exchanges",csvString(exchanges));
        }
        return this;
    }

    public CryptoTopOfTheBookParameters setIncludeRawExchangeData(boolean b) {
        map.put("includeRawExchangeData",String.valueOf(b));
        return this;
    }


}
