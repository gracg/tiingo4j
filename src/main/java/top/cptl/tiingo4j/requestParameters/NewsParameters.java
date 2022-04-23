package top.cptl.tiingo4j.requestParameters;

import top.cptl.tiingo4j.abstracts.AbstractParameters;
import top.cptl.tiingo4j.enums.NEWS_SORT;

import java.time.format.DateTimeParseException;
import java.util.List;

public class NewsParameters extends AbstractParameters {


    public NewsParameters setTickers(List<String> tickers) {
        if(tickers!=null) {
            String str = csvString(tickers);
            map.put("tickers",str);
        }
        return this;
    }

    public NewsParameters setTags(List<String> tags) {
        if(tags!=null) {
            String str = csvString(tags);
            map.put("tags",str);
        }
        return this;
    }

    public NewsParameters setSources(List<String> sources) {
        if(sources!=null) {
            String str = csvString(sources);
            map.put("source",str);
        }
        return this;
    }

    public NewsParameters setStartDate(String date) {
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

    public NewsParameters setEndDate(String date) {
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

    public NewsParameters setLimit(int limit) {
        limit = limit<=0?100:limit;
        map.put("limit",String.valueOf(limit));
        return this;
    }

    public NewsParameters setOffSet(int offSet) {
        offSet = offSet<0?0:offSet;
        map.put("offset",String.valueOf(offSet));
        return this;
    }

    public NewsParameters setSortBy(NEWS_SORT sort) {
        map.put("sortBy",sort.toString());
        return this;
    }

    public NewsParameters setOnlyWithTickers(boolean bool) {
        map.put("onlyWithTickers",String.valueOf(bool));
        return this;
    }


}
