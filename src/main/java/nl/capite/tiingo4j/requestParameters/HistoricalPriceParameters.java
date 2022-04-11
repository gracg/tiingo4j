package nl.capite.tiingo4j.requestParameters;

import nl.capite.tiingo4j.abstracts.AbstractParameters;
import nl.capite.tiingo4j.enums.HISTORICAL_PRICE_SORT;
import nl.capite.tiingo4j.enums.RESAMPLE_FREQUENCY;

import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class HistoricalPriceParameters extends AbstractParameters {
    private final HashMap<String,String> map = new HashMap<>();

    public HistoricalPriceParameters setStartDate(String date) {
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

    public HistoricalPriceParameters setEndDate(String date) {
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

    public HistoricalPriceParameters setResampleFrequency(RESAMPLE_FREQUENCY frequency) {
        map.put("resampleFreq",frequency.toString());
        return this;
    }

    public HistoricalPriceParameters setSort(HISTORICAL_PRICE_SORT sort) {
        map.put("sort", sort.toString());
        return this;
    }


}
