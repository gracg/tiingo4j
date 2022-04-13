package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.*;
import nl.capite.tiingo4j.requestParameters.CryptoPriceParameters;
import nl.capite.tiingo4j.requestParameters.CryptoTopOfTheBookParameters;
import nl.capite.tiingo4j.requestParameters.PriceParameters;
import nl.capite.tiingo4j.requestParameters.NewsParameters;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TiingoApi {

    private final StockApi stockApi;
    private final NewsApi newsApi;
    private final CryptoApi cryptoApi;

    public TiingoApi(String apiKey) {
        stockApi = new StockApi(apiKey);
        newsApi = new NewsApi(apiKey);
        cryptoApi = new CryptoApi(apiKey);
    }

    public Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
        return stockApi.getMeta(ticker);
    }

    public List<Price> getPrices(String ticker, PriceParameters parameters) throws IOException, ApiException {
        return stockApi.getPrices(ticker, parameters);
    }

    public List<Article> getNews(NewsParameters parameters) throws IOException, ApiException {
        return newsApi.getNews(parameters);
    }

    public List<CryptoTopOfTheBook> getCryptoTopOfTheBook(List<String> tickers, CryptoTopOfTheBookParameters parameters) throws IOException, ApiException {
        return cryptoApi.getCryptoTopOfTheBook(tickers, parameters);
    }

    public List<CryptoMeta> getCryptoMetas(List<String> tickers) throws IOException, ApiException {
        return cryptoApi.getCryptoMetas(tickers);
    }

    public List<CryptoPrice> getCryptoPrices(List<String> tickers, CryptoPriceParameters parameters) throws IOException, ApiException {
        return cryptoApi.getCryptoPrices(tickers, parameters);
    }
}