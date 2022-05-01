package top.cptl.tiingo4j.apis;

import okhttp3.Request;
import okhttp3.Response;
import top.cptl.tiingo4j.abstracts.AbstractApi;
import top.cptl.tiingo4j.exceptions.ApiException;
import top.cptl.tiingo4j.models.IexTopOfTheBook;

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
}
