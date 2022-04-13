package nl.capite.tiingo4j.apis;

import nl.capite.tiingo4j.abstracts.AbstractApi;
import nl.capite.tiingo4j.exceptions.ApiException;
import nl.capite.tiingo4j.models.Price;
import nl.capite.tiingo4j.models.Meta;
import nl.capite.tiingo4j.requestParameters.HistoricalPriceParameters;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class StockApi  extends AbstractApi {
    public StockApi(String apiKey) {
        super(apiKey);
    }

    public Optional<Meta> getMeta(String ticker) throws IOException, ApiException {
        return super.getMeta(ticker);
    }

    public List<Price> getPrices(String ticker, HistoricalPriceParameters parameters) throws IOException, ApiException {
        return super.getPrices(ticker,parameters);
    }
}
