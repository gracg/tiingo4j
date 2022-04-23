package top.cptl.tiingo4j.requestParameters;

import top.cptl.tiingo4j.abstracts.AbstractParameters;
import top.cptl.tiingo4j.enums.PRICE_SORT;
import top.cptl.tiingo4j.enums.RESAMPLE_FREQUENCY;

import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class PriceParameters extends AbstractParameters {

    public PriceParameters setStartDate(String date) {
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

    public PriceParameters setEndDate(String date) {
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

    public PriceParameters setResampleFrequency(RESAMPLE_FREQUENCY frequency) {
        map.put("resampleFreq",frequency.toString());
        return this;
    }

    public PriceParameters setSort(PRICE_SORT sort) {
        map.put("sort", sort.toString());
        return this;
    }


    @Override
    public HashMap<String, String> getMap() {
       return map;
    }
}
