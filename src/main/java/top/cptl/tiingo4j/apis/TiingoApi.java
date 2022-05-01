package top.cptl.tiingo4j.apis;

import top.cptl.tiingo4j.exceptions.ApiException;
import top.cptl.tiingo4j.models.*;
import top.cptl.tiingo4j.requestParameters.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TiingoApi {

    private final StockApi stockApi;
    private final NewsApi newsApi;
    private final CryptoApi cryptoApi;
    private final IexApi iexApi;

    public TiingoApi(String apiKey) {
        stockApi = new StockApi(apiKey);
        newsApi = new NewsApi(apiKey);
        cryptoApi = new CryptoApi(apiKey);
        iexApi = new IexApi(apiKey);
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

    public List<IexTopOfTheBook> getIexTopOfTheBook(List<String> tickers) throws IOException, ApiException {
        return iexApi.getIexTopOfTheBook(tickers);
    }

    public List<IexPrice> getIexPrices(String ticker, IexPriceParameters parameters) throws IOException, ApiException {
        return iexApi.getIexPrices(ticker,parameters);
    }
}