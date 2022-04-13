package nl.capite.tiingo4j.abstracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.exceptions.InvalidApiKeyException;
import nl.capite.tiingo4j.exceptions.InvalidTickerException;
import nl.capite.tiingo4j.models.*;
import nl.capite.tiingo4j.requestParameters.CryptoTopOfTheBookParameters;
import nl.capite.tiingo4j.requestParameters.HistoricalPriceParameters;
import nl.capite.tiingo4j.requestParameters.NewsParameters;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class AbstractApi {

    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
            ;
    private final ObjectMapper mapper = new ObjectMapper();

    protected AbstractApi(String apiKey) {
        this.apiKey = apiKey;
    }


    private <T extends AbstractParameters> Request createRequest(String urlStr, T parameters) {
        if(parameters==null || parameters.getMap()==null) {
            return createRequestFromMap(urlStr,null);
        }
        return createRequestFromMap(urlStr,parameters.getMap());
    }

    private Request createRequestFromMap(String urlStr,Map<String,String> parameters) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStr).newBuilder();
        if(parameters!=null) {
            for(Map.Entry<String,String> entry:parameters.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(),entry.getValue());
            }
        }
        HttpUrl urlObj = urlBuilder.build();
        System.out.println(urlObj.url().toString());
        return new Request.Builder()
                .url(urlObj)
                .addHeader("Authorization","Token " + apiKey)
                .addHeader("Content-Type","application/json")
                .build();
    }

    private ApiException parseError(String body, Object o) {

        try {
            ErrorModel e = mapper.readValue(body,ErrorModel.class);
            ApiException exception;

            if(e.getDetail().equals("Not found.") || e.getDetail().contains("Error: Ticker")) {
                return new ApiException(new InvalidTickerException((String) o));
            }
            if(e.getDetail().equals("Invalid token.")) {
                return new ApiException(new InvalidApiKeyException());
            }

            return new ApiException(new Exception(body));

        } catch (JsonProcessingException ex) {
            return new ApiException(ex);
        }
    }

    private boolean isStatus2XX(Integer status) {
        String statusString = String.valueOf(status);
        return statusString.startsWith("2");
    }

    private String csvString(List<String> strings) {
        StringBuilder sb = new StringBuilder();

        if(strings!=null) {
            strings.forEach(word -> sb.append(word+","));
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

    protected Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
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

    protected List<Price> getPrices(String ticker, HistoricalPriceParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/daily/" + ticker + "/prices";
        Request request = createRequest(url,parameters);

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        if(!isStatus2XX(response.code())) {
            throw parseError(body,ticker);
        }
        var x = mapper.readValue(body, Price[].class);
        return x==null?new ArrayList<>(): Arrays.asList(x);
    }

    protected List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/news";
        Request request = createRequest(url,parameters);

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        var x = mapper.readValue(body,Article[].class);
        return  x==null?new ArrayList<>():Arrays.asList(x);
    }

    protected List<CryptoTopOfTheBook> getCryptoTopOfTheBook(List<String> tickers, CryptoTopOfTheBookParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/crypto/top";



        if(tickers==null) {
            throw new NullPointerException("tickers parameters cannot be null.");
        }
        if(tickers.size()==0) {
            throw new NullPointerException("tickers list must include at least one ticker.");
        }

        HashMap<String,String> params = new HashMap<>();
        if(parameters!=null) {
            params = parameters.getMap();
        }

        String tickerStringList = csvString(tickers);
        params.put("tickers",tickerStringList);

        Request request = createRequestFromMap(url,params);

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        CryptoTopOfTheBook[] data = mapper.readValue(body,CryptoTopOfTheBook[].class);
        return  data==null ? new ArrayList<>():Arrays.asList(data);
    }

}
