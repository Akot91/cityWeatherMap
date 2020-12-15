package com.cityweathermap.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CurrentInstallations {

    private static final List<Integer> allCityIndexes = Arrays.asList(
            25, 7756, 10490, 12, 11510, 7491, 61, 52, 111, 102, 32792, 54, 26, 119, 8077, 9095, 6947, 7468, 45, 10, 49, 78);
    private List<CurrentDto> currentDtos = new ArrayList<>();
    private List<CityDto> cityDtos = new ArrayList<>();
    private List<CityDto> allCities = new ArrayList<>();

    public void createCityDtos(List<CityDto> cityDtos) {
        cityDtos.addAll(cityDtos);
    }

    public void createCurrentDtos(List<CurrentDto> currentDtos) {
        currentDtos.addAll(currentDtos);
    }

    public void createAllCities(List<CityDto> cityDtos) {allCities.addAll(cityDtos);}

    public List<CityDto> getCityDtos() {
        return cityDtos;
    }

    public List<CurrentDto> getCurrentDtos() {
        return currentDtos;
    }

    public List<CityDto> getAllCities() {return allCities;}

    public List<Integer> getAllCityIndexes() {return allCityIndexes;}
}
