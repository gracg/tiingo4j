package top.cptl.tiingo4j.exceptions;

public class InvalidApiKeyException extends Exception{
    public InvalidApiKeyException() {
        super("Api key is invalid.");
    }
}
