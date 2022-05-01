package top.cptl.tiingo4j.requestParameters;

import top.cptl.tiingo4j.abstracts.AbstractParameters;
import top.cptl.tiingo4j.enums.IEX_RESAMPLE_FREQUENCY;

import java.time.format.DateTimeParseException;

public class IexPriceParameters extends AbstractParameters {

    public IexPriceParameters setStartDate(String date) {
        if (date!=null) {
            try {
                isValidStandardDate(date);
            } catch (DateTimeParseException e) {
                throw e;
            }
            map.put("startDate",date);
        }
        return this;
    }

    public IexPriceParameters setEndDate(String date) {
        if (date!=null) {
            try {
                isValidStandardDate(date);
            } catch (DateTimeParseException e) {
                throw e;
            }
            map.put("endDate",date);
        }
        return this;
    }

    public IexPriceParameters setResampleFrequency(int number,IEX_RESAMPLE_FREQUENCY frequency) {
        if(number>0) {
            map.put("resampleFreq",String.valueOf(number) + frequency.toString());
        }
        return this;
    }

    public IexPriceParameters setAfterHours(boolean value) {
        if(value==true) {
            map.put("afterHours","true");
        }
        return this;
    }

    public IexPriceParameters setForceFill(boolean value) {
        if(value==true) {
            map.put("forceFill","true");
        }
        return this;
    }


}
