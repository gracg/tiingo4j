package nl.capite.tiingo4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.exceptions.InvalidApiKeyException;
import nl.capite.tiingo4j.exceptions.InvalidTickerException;
import nl.capite.tiingo4j.models.ErrorModel;
import nl.capite.tiingo4j.models.HistoricalPrice;
import nl.capite.tiingo4j.models.Meta;
import nl.capite.tiingo4j.requestParameters.HistoricalPriceParameters;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;


public class Tiingo {

    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();


    public Tiingo(String apiKey) {
        this.apiKey=apiKey;
    }


    private Request createRequest(String urlStr, HashMap<String,String> parameters) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStr).newBuilder();
        if(parameters!=null) {
            for(Map.Entry<String,String> entry:parameters.entrySet()) {
               urlBuilder.addQueryParameter(entry.getKey(),entry.getValue());
            }
        }
        HttpUrl urlObj = urlBuilder.build();

        return new Request.Builder()
                .url(urlObj)
                .addHeader("Authorization","Token " + apiKey)
                .addHeader("Content-Type","application/json")
                .build();
    }

    private ApiException parseError(String body,Object o) {

        try {
            ErrorModel e = mapper.readValue(body,ErrorModel.class);
            ApiException exception;

            if(e.getDetail().equals("Not found.")) {
                return new ApiException(new InvalidTickerException((String) o));
            }
            if(e.getDetail().equals("Invalid token.")) {
                return new ApiException(new InvalidApiKeyException());
            }

            return new ApiException(null);

        } catch (JsonProcessingException ex) {
            return new ApiException(ex);
        }
    }

    private boolean isStatus2XX(Integer status) {
        String statusString = String.valueOf(status);
        return statusString.startsWith("2");
    }


    public Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/daily/" + ticker;
        Request request = createRequest(url,null);

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        List<Integer> x = new ArrayList<>();
        if(!isStatus2XX(response.code())) {
            throw parseError(body,ticker);
        }

        return Optional.of(mapper.readValue(body,Meta.class));
    }

    public List<HistoricalPrice> getHistoricalPrices(String ticker, HistoricalPriceParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/daily/" + ticker + "/prices";
        Request request = createRequest(url,parameters.getMap());

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }
        var x = mapper.readValue(body,HistoricalPrice[].class);
        return x==null?new ArrayList<>():Arrays.asList(x);
    }


}
