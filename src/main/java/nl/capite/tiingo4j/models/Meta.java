package nl.capite.tiingo4j.models;

import lombok.Data;

@Data
public class Meta {
    private String ticker;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
}
