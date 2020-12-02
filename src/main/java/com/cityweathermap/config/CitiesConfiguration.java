package com.cityweathermap.config;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CitiesConfiguration {

    private final List<Integer> cities = Arrays.asList(26, 119, 8077, 9095, 6947, 7468, 45, 10, 49, 78);

    public CitiesConfiguration() {
    }

    public List<Integer> getCities() {
        return cities;
    }
}
