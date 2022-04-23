package top.cptl.tiingo4j.enums;

public enum NEWS_SORT {
    PUBLISHED_DATE("publishedDate"),
    CRAWL_DATE("crawlDate");

    private String value;
    NEWS_SORT(String string){
        this.value=string;
    }

    @Override
    public String toString() {
        return value;
    }
}
