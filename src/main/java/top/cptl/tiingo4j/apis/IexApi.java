package top.cptl.tiingo4j.apis;

import okhttp3.Request;
import okhttp3.Response;
import top.cptl.tiingo4j.abstracts.AbstractApi;
import top.cptl.tiingo4j.exceptions.ApiException;
import top.cptl.tiingo4j.models.IexPrice;
import top.cptl.tiingo4j.models.IexTopOfTheBook;
import top.cptl.tiingo4j.requestParameters.IexPriceParameters;

import java.io.IOException;
import java.util.*;

public class IexApi extends AbstractApi {
    public IexApi(String apiKey) {
        super(apiKey);
    }

    public List<IexTopOfTheBook> getIexTopOfTheBook(List<String> tickers) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/iex";
        Map<String,String> parameters = new HashMap<>();
        if(tickers!=null&&tickers.size()!=0) {
            parameters.put("tickers",csvString(tickers));
        }

        Request request = createRequestFromMap(url,parameters);
        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        IexTopOfTheBook[] books = mapper.readValue(body,IexTopOfTheBook[].class);
        return books==null? new ArrayList<>(): Arrays.asList(books);
    }

    public List<IexPrice> getIexPrices(String ticker, IexPriceParameters parameters) throws IOException, ApiException {
        if(ticker==null || ticker.isEmpty()) {
            throw new IllegalArgumentException("ticker cannot be empty or null");
        }
        final String url = "https://api.tiingo.com/iex/" + ticker + "/prices";

        Request request = createRequest(url,parameters);
        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        IexPrice[] prices = mapper.readValue(body,IexPrice[].class);
        return prices==null?new ArrayList<>(): Arrays.asList(prices);
    }
}
