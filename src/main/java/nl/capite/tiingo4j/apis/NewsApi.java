package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.Article;
import nl.capite.tiingo4j.requestParameters.NewsParameters;

import java.io.IOException;
import java.util.List;

public class NewsApi extends AbstractApi {

    public NewsApi(String apiKey) {
        super(apiKey);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        return super.getNews(parameters);
    }
}
