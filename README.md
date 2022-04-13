# Tiingo4j

The purpose of this library is to provide a standard interface to interact with the Tiingo api using java. Tiingo4j implements the stock, crypto and news endpoints.
A [Tiingo](https://api.tiingo.com/) account and api key are needed to use Tiingo4j.

### Getting Started
Tiingo4j offers several apis for interfacing with Tiingo. The TiingoApi is a consolidated version of the stock,crypto and news apis.

```java


    TiingoApi tiingo = new TiingoApi("apikey_here");

    // This gets daily stock prices for the T ticker.
    // The second parameter is a parameters object for the request.        
    List<Price> prices = tiingo.getPrices("T",null);
    
    // Using Parameters to get prices from 2020-01-20 to 2020-12-31 using weeks as a unit of time.
    PriceParameters parameters = new PriceParameters()
            .setStartDate("2020-01-20")
            .setEndDate("2020-12-31")
            .setResampleFrequency(RESAMPLE_FREQUENCY.WEEKLY);

    List<Price> prices = tiingo.getPrices("T",parameters);
    
    // Getting news.
    // the first parameter is a paramater object.        
    List<Article> newsArticles = tiingo.getNews(null);
    
    // Using Parameters to get news with specific tickers with a specific time period.
    List<String> tickers = new ArrayList<>(Arrays.asList("T","VZ","TMUS"));

    NewsParameters newsParameters = new NewsParameters()
            .setTickers(tickers)
            .setStartDate("2020-01-20")
            .setEndDate("2020-12-31");

    List<Article> newsArticles = tiingo.getNews(newsParameters);
    
    //Getting crypto prices
    //Second parameter is parameter object        
    List<String> cryptoTickers = new ArrayList<>(Arrays.asList("ETHBTC","BTCUSD"));
   
    List<CryptoPrice> cryptoPrices = tiingo.getCryptoPrices(tickers,null);
   
    
    // Using parameters to specify a range of time and a unit of time.
    List<String> cryptoTickers = new ArrayList<>(Arrays.asList("ETHBTC","BTCUSD"));

    CryptoPriceParameters cryptoParameters = new CryptoPriceParameters()
            .setStartDate("2021-01-01")
            .setEndDate("2022-12-31")
            .setResampleFrequency(3,CRYPTO_RESAMPLE_FREQUENCY.HOUR); // 3 hour candle.
    
    List<CryptoPrice> cryptoPrices = tiingo.getCryptoPrices(cryptoTickers,cryptoParameters);

```