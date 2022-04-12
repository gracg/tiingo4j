package nl.capite.tiingo4j.exceptions;

public class ApiException extends Exception{

    public final Exception exception;

    public ApiException(Exception e) {
        super(e.getMessage());
        exception=e;
    }

}
