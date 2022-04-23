package top.cptl.tiingo4j.requestParameters;

import top.cptl.tiingo4j.abstracts.AbstractParameters;
import top.cptl.tiingo4j.enums.CRYPTO_RESAMPLE_FREQUENCY;

import java.time.format.DateTimeParseException;
import java.util.List;

public class CryptoPriceParameters extends AbstractParameters {

    public CryptoPriceParameters setExchanges(List<String> exchanges) {
        if(exchanges!=null && exchanges.size()>0) {
            map.put("exchanges",csvString(exchanges));
        }
        return this;
    }

    public CryptoPriceParameters setStartDate(String date) {
        if(date!=null) {
            try {
                isValidStandardDate(date);
            } catch (DateTimeParseException e) {
                throw e;
            }

            map.put("startDate",date);
        }
        return this;
    }

    public CryptoPriceParameters setEndDate(String date) {
        if(date!=null) {
            try {
                isValidStandardDate(date);
            } catch (DateTimeParseException e) {
                throw e;
            }

            map.put("endDate",date);
        }
        return this;
    }

    public CryptoPriceParameters setResampleFrequency(int number, CRYPTO_RESAMPLE_FREQUENCY frequency) {
        number = number<=0?1:number;
        map.put("resampleFreq",String.valueOf(number)+frequency.toString());
        return this;
    }

    public CryptoPriceParameters setIncludeRawExchangeData(boolean bool) {
        map.put(" includeRawExchangeData ",String.valueOf(bool));
        return this;
    }

}
