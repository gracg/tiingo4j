package top.cptl.tiingo4j.models;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private String publishedDate;
    private String crawlDate;
    private String source;
    private String[] tickers;
    private String[] tags;
}
