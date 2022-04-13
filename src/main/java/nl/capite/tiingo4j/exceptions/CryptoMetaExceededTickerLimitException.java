package nl.capite.tiingo4j.exceptions;

public class CryptoMetaExceededTickerLimitException extends Exception {
    public CryptoMetaExceededTickerLimitException() {
        super("Tickers list cannot exceed 100 tickers.");
    }
}
