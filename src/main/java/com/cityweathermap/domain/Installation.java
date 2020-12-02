package com.cityweathermap.domain;

import java.util.List;

public class Installation {

    private String fromDateTime;
    private String tillDateTime;
    private List<Value> values;

    public Installation(String fromDateTime, String tillDateTime, List<Value> values) {
        this.fromDateTime = fromDateTime;
        this.tillDateTime = tillDateTime;
        this.values = values;
    }

    public String getFromDateTime() {
        return fromDateTime;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }

    public List<Value> getValues() {
        return values;
    }
}
