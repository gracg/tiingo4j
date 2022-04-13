package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.exceptions.CryptoMetaExceededTickerLimitException;
import nl.capite.tiingo4j.models.CryptoMeta;
import nl.capite.tiingo4j.models.CryptoPrice;
import nl.capite.tiingo4j.models.CryptoTopOfTheBook;
import nl.capite.tiingo4j.requestParameters.CryptoPriceParameters;
import nl.capite.tiingo4j.requestParameters.CryptoTopOfTheBookParameters;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CryptoApi extends AbstractApi {

    public CryptoApi(String apiKey) {
        super(apiKey);
    }

    public List<CryptoTopOfTheBook> getCryptoTopOfTheBook(List<String> tickers, CryptoTopOfTheBookParameters parameters) throws IOException, ApiException {
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
        return  data==null ? new ArrayList<>(): Arrays.asList(data);
    }

    public List<CryptoMeta> getCryptoMetas(List<String> tickers) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/crypto";

        HashMap<String,String> params = new HashMap<>();
        if(tickers!=null&&tickers.size()>0) {
            if(tickers.size()>100) {
                throw new ApiException(new CryptoMetaExceededTickerLimitException());
            }
            params.put("tickers",csvString(tickers));
        }

        Request request = createRequestFromMap(url,params);
        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,csvString(tickers));
        }

        CryptoMeta[] metas = mapper.readValue(body,CryptoMeta[].class);
        return metas==null? new ArrayList<>():Arrays.asList(metas);
    }


    public List<CryptoPrice> getCryptoPrices(List<String> tickers, CryptoPriceParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/crypto/prices";

        HashMap<String,String> params = new HashMap<>();
        if(parameters!=null) {
            params = parameters.getMap();
        }

        if(tickers==null || tickers.size()==0) {
            throw new NullPointerException("Tickers list must include at least one ticker.");
        }
        params.put("tickers",csvString(tickers));

        Request request = createRequestFromMap(url,params);
        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        CryptoPrice[] data = mapper.readValue(body,CryptoPrice[].class);
        return  data==null? new ArrayList<>():Arrays.asList(data);
    }
}
