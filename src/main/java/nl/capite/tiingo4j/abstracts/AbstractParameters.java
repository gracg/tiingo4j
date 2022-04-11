package nl.capite.tiingo4j.abstracts;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class AbstractParameters {
    private final DateTimeFormatter standardDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    protected boolean isValidStandardDate(String dateStr) {
        try {
            standardDateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw e;
        }
        return true;
    }
}
