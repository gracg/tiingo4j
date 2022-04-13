package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.*;
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

    public List<Price> getPrices(String ticker, HistoricalPriceParameters parameters) throws IOException, ApiException {
        return super.getPrices(ticker,parameters);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        return super.getNews(parameters);
    }

    public List<CryptoTopOfTheBook> getCryptoTopOfTheBook(List<String> tickers, List<String> exchanges) throws IOException, ApiException {
        return super.getCryptoTopOfTheBook(tickers,exchanges);
    }

}
