package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.Article;
import nl.capite.tiingo4j.models.HistoricalPrice;
import nl.capite.tiingo4j.models.Meta;
import nl.capite.tiingo4j.requestParameters.HistoricalPriceParameters;
import nl.capite.tiingo4j.requestParameters.NewsParameters;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TiingoApi extends AbstractApi {

    public TiingoApi(String apiKey) {
        super(apiKey);
    }

    public Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
        return super.getMeta(ticker);
    }

    public List<HistoricalPrice> getHistoricalPrices(String ticker, HistoricalPriceParameters parameters) throws IOException, ApiException {
        return super.getHistoricalPrices(ticker,parameters);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        return super.getNews(parameters);
    }
}
