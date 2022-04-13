package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.Price;
import nl.capite.tiingo4j.models.Meta;
import nl.capite.tiingo4j.requestParameters.PriceParameters;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StockApi  extends AbstractApi {
    public StockApi(String apiKey) {
        super(apiKey);
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

    public List<Price> getPrices(String ticker, PriceParameters parameters) throws IOException, ApiException {
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
}
