package nl.capite.tiingo4j.abstracts;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;

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

    protected String csvString(List<String> strings) {
        StringBuilder sb = new StringBuilder();

        if(strings!=null) {
            strings.forEach(word -> sb.append(word+","));
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

    public HashMap<String,String> getMap() {
        return map;
    }
}
