package nl.capite.tiingo4j.abstracts;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public abstract class AbstractParameters {
    private final DateTimeFormatter standardDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected final HashMap<String,String> map = new HashMap<>();

    protected boolean isValidStandardDate(String dateStr) {
        try {
            standardDateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw e;
        }
        return true;
    }

    public HashMap<String,String> getMap() {
        return map;
    }
}
