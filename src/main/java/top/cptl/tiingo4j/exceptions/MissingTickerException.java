package top.cptl.tiingo4j.exceptions;

public class MissingTickerException extends Exception {
    public MissingTickerException() {
        super("tickers cannot be null.");
    }
}
