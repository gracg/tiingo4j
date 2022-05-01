package top.cptl.tiingo4j.apis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.cptl.tiingo4j.enums.IEX_RESAMPLE_FREQUENCY;
import top.cptl.tiingo4j.exceptions.ApiException;
import top.cptl.tiingo4j.models.IexTopOfTheBook;
import top.cptl.tiingo4j.requestParameters.IexPriceParameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IexApiTest {

    private final static String apikey = System.getenv("tiingo4j_key");

    @BeforeAll
    @DisplayName("Iex api key test")
    static void testApiKeyEnvironmentVariable() {
        assertNotNull(System.getenv("tiingo4j_key"));
    }


    @Test
    @DisplayName("Iex Top Of The Book Specific tickers")
    void IexTopOfTheBookSpecificTickersTest() {
        assertDoesNotThrow(() -> {
            new IexApi(apikey).getIexTopOfTheBook(Arrays.asList(new String[]{"AAPL","TSLA"}));
        });
    }

    @Test
    @DisplayName("Iex Price Test")
    void IexPriceTest() throws IOException, ApiException {
        assertDoesNotThrow(() -> {
            new IexApi(apikey).getIexPrices("TSLA",null);
        });
    }
}