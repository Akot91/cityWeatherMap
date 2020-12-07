package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexesDto {

    @JsonProperty(value = "level")
    private String level;

    public IndexesDto() {}

    public IndexesDto(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
