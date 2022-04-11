package nl.capite.tiingo4j.enums;

public enum HISTORICAL_PRICE_SORT {
    DATE("date"),
    DATE_DESC("-date"),
    OPEN("open"),
    OPEN_DESC("-open"),
    HIGH("high"),
    HIGH_DESC("-high"),
    LOW("low"),
    LOW_DESC("-low"),
    CLOSE("close"),
    CLOSE_DESC("-close"),
    VOLUME("volume"),
    VOLUME_DESC("-volume"),
    ADJ_OPEN("adjOpen"),
    ADJ_OPEN_DESC("-adjOpen"),
    ADJ_HIGH("adjHigh"),
    ADJ_HIGH_DESC("-adjHigh"),
    ADJ_LOW("adjLow"),
    ADJ_LOW_DESC("-adjLow"),
    ADJ_CLOSE("adjClose"),
    ADJ_CLOSE_DESC("-adjClose"),
    ADJ_VOLUME("adjVolume"),
    ADJ_VOLUME_DESC("-adjVolume"),
    DIVIDEND("divCash"),
    DIVIDEND_DESC("-divCash"),
    SPLIT("splitFactor"),
    SPLIT_DESC("-splitFactor");

    private String value;
    HISTORICAL_PRICE_SORT(String string){value=string;}

    @Override
    public String toString() {
        return value;
    }
}
