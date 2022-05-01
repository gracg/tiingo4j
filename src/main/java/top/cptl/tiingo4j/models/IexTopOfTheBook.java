package top.cptl.tiingo4j.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IexTopOfTheBook {
    private String ticker;
    private String timestamp;
    private String quoteTimestamp;
    private String lastSaleTimestamp;
    private Double last;
    private Integer lastSize;
    @JsonProperty("tngoLast")
    private Double tiingoLast;
    @JsonProperty("prevClose")
    private Double previousClose;
    private Double open;
    private Double high;
    private Double low;
    private Double mid;
    private Integer volume;
    private Double bidSize;
    private Double bidPrice;
    private Double askSize;
    private Double askPrice;
}
