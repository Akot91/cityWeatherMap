package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstallationDto {

    @JsonProperty(value = "fromDateTime")
    private String fromDateTime;

    @JsonProperty(value = "tillDateTime")
    private String tillDateTime;

    @JsonProperty(value = "values")
    private List<ValueDto> values;

    @JsonProperty(value = "indexes")
    private List<IndexesDto> indexes;

    public InstallationDto() {}

    public InstallationDto(String fromDateTime, String tillDateTime, List<ValueDto> values, List<IndexesDto> indexes) {
        this.fromDateTime = fromDateTime;
        this.tillDateTime = tillDateTime;
        this.values = values;
        this.indexes = indexes;
    }

    public String getFromDateTime() {
        return fromDateTime;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }

    public List<ValueDto> getValues() {
        return values;
    }

    public List<IndexesDto> getIndexes() {
        return indexes;
    }
}
