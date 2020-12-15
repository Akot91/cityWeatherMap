package com.cityweathermap.airly.client;

import com.cityweathermap.airly.config.AirlyConfig;
import com.cityweathermap.config.CitiesConfiguration;
import com.cityweathermap.controller.CityListController;
import com.cityweathermap.controller.CityListNotFoundException;
import com.cityweathermap.domain.CityDto;
import com.cityweathermap.domain.CurrentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AirlyClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AirlyConfig airlyConfig;

    @Autowired
    private CityListController cityListController;

    @Autowired
    private CitiesConfiguration citiesConfiguration;

    public List<CurrentDto> getInstallations(Long id) throws CityListNotFoundException {
        List<CurrentDto> currentDtos = new ArrayList<>();
        citiesConfiguration.createNewConfiguration(cityListController.getCityList(id));
        for (Integer city : citiesConfiguration.getCities()) {
            currentDtos.addAll(Arrays.asList(Optional.ofNullable(restTemplate.getForObject(getInstallationUrl(city), CurrentDto.class)).orElseGet(() -> new CurrentDto())));
        }
        return currentDtos;
    }

    public List<CityDto> getCities(Long id) throws CityListNotFoundException {
        List<CityDto> cityDtos = new ArrayList<>();
        citiesConfiguration.createNewConfiguration(cityListController.getCityList(id));
        for (Integer city : citiesConfiguration.getCities()) {
            cityDtos.addAll(Arrays.asList(Optional.ofNullable(restTemplate.getForObject(getCityUrl(city), CityDto.class)).orElseGet(() -> new CityDto())));
        }
        return cityDtos;
    }

    public List<CityDto> getAllEnabledCities(List<Integer> cityIndexes) {
        List<CityDto> cityDtos = new ArrayList<>();
        for (Integer city : cityIndexes) {
            cityDtos.addAll(Arrays.asList(Optional.ofNullable(restTemplate.getForObject(getCityUrl(city), CityDto.class)).orElseGet(() -> new CityDto())));
        }
        return cityDtos;
    }

    private URI getInstallationUrl(Integer city) {
        URI url = UriComponentsBuilder.fromHttpUrl(airlyConfig.getAirlyEndpoint() + "/v2/measurements/installation/")
                .queryParam("apikey", airlyConfig.getAirlyApiKey())
                .queryParam("installationId", city)
                .build().encode().toUri();
        return url;
    }

    private URI getCityUrl(Integer city) {
        URI url = UriComponentsBuilder.fromHttpUrl(airlyConfig.getAirlyEndpoint() + "/v2/installations/" + city + "/")
                .queryParam("apikey", airlyConfig.getAirlyApiKey())
                .build().encode().toUri();
        return url;
    }
}
