package com.cityweathermap.airly.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AirlyConfig {

    @Value("${airly.api.key}")
    private String airlyApiKey;

    @Value("${airly.api.endpoint}")
    private String airlyEndpoint;

    public String getAirlyApiKey() {
        return airlyApiKey;
    }

    public String getAirlyEndpoint() {
        return airlyEndpoint;
    }
}
