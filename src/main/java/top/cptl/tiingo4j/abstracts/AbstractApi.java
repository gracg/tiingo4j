package top.cptl.tiingo4j.abstracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.cptl.tiingo4j.exceptions.ApiException;
import top.cptl.tiingo4j.exceptions.InvalidApiKeyException;
import top.cptl.tiingo4j.exceptions.InvalidTickerException;
import top.cptl.tiingo4j.models.ErrorModel;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class AbstractApi {

    private final String apiKey;
    protected final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
            ;
    protected final ObjectMapper mapper = new ObjectMapper();

    protected AbstractApi(String apiKey) {
        this.apiKey = apiKey;
    }


    protected  <T extends AbstractParameters> Request createRequest(String urlStr, T parameters) {
        if(parameters==null || parameters.getMap()==null) {
            return createRequestFromMap(urlStr,null);
        }
        return createRequestFromMap(urlStr,parameters.getMap());
    }

    protected Request createRequestFromMap(String urlStr,Map<String,String> parameters) {
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

    protected ApiException parseError(String body, Object o) {

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

    protected boolean isStatus2XX(Integer status) {
        String statusString = String.valueOf(status);
        return statusString.startsWith("2");
    }

    protected String csvString(List<String> strings) {
        StringBuilder sb = new StringBuilder();

        if(strings!=null) {
            strings.forEach(word -> sb.append(word+","));
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

}
