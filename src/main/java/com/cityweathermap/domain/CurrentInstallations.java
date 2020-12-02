package com.cityweathermap.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrentInstallations {

    private List<CurrentDto> currentDtos = new ArrayList<>();
    private List<CityDto> cityDtos = new ArrayList<>();

    public void createCityDtos(List<CityDto> cityDtos) {
        this.cityDtos.addAll(cityDtos);
    }

    public void createCurrentDtos(List<CurrentDto> currentDtos) {
        this.currentDtos.addAll(currentDtos);
    }

    public List<CityDto> getCityDtos() {
        return cityDtos;
    }

    public List<CurrentDto> getCurrentDtos() {
        return currentDtos;
    }
}
