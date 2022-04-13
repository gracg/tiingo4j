package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.*;
import nl.capite.tiingo4j.requestParameters.CryptoTopOfTheBookParameters;
import nl.capite.tiingo4j.requestParameters.PriceParameters;
import nl.capite.tiingo4j.requestParameters.NewsParameters;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TiingoApi extends AbstractApi {

    private final StockApi stockApi;

    public TiingoApi(String apiKey) {
        super(apiKey);
        stockApi = new StockApi(apiKey);
    }

    public Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
        return stockApi.getMeta(ticker);
    }

    public List<Price> getPrices(String ticker, PriceParameters parameters) throws IOException, ApiException {
        return stockApi.getPrices(ticker,parameters);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        return super.getNews(parameters);
    }

    public List<CryptoTopOfTheBook> getCryptoTopOfTheBook(List<String> tickers, CryptoTopOfTheBookParameters parameters) throws IOException, ApiException {
        return super.getCryptoTopOfTheBook(tickers,parameters);
    }

}
