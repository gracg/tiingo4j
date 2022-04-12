package nl.capite.tiingo4j.exceptions;

public class InvalidTickerException extends  Exception {
    public InvalidTickerException(String ticker) {
        super(ticker + " is not a supported ticker.");
    }
}
