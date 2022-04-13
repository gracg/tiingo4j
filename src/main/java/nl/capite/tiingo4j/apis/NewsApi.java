package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.Article;
import nl.capite.tiingo4j.requestParameters.NewsParameters;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsApi extends AbstractApi {

    public NewsApi(String apiKey) {
        super(apiKey);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        final String url = "https://api.tiingo.com/tiingo/news";
        Request request = createRequest(url,parameters);

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if(!isStatus2XX(response.code())) {
            throw parseError(body,null);
        }

        var x = mapper.readValue(body,Article[].class);
        return  x==null?new ArrayList<>(): Arrays.asList(x);
    }
}
