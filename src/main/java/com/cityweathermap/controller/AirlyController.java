package com.cityweathermap.controller;

import com.cityweathermap.airly.client.AirlyClient;
import com.cityweathermap.domain.CityDto;
import com.cityweathermap.domain.CurrentDto;
import com.cityweathermap.domain.CurrentInstallations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/airly/installations")
public class AirlyController {

    @Autowired
    private AirlyClient airlyClient;

    @Autowired
    private CurrentInstallations currentInstallations;

    public List<CurrentDto> getCreatedCurrentInstallations() throws CityListNotFoundException {
        if (currentInstallations.getCurrentDtos().isEmpty()) {
            currentInstallations.createCurrentDtos(airlyClient.getInstallations(1L));
        }
        return currentInstallations.getCurrentDtos();
    }

    public List<CityDto> getCreatedCurrentCities() throws CityListNotFoundException {
        if (currentInstallations.getCityDtos().isEmpty()) {
            currentInstallations.createCityDtos(airlyClient.getCities(1L));
        }
        return currentInstallations.getCityDtos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public List<CurrentDto> getInstallations() throws CityListNotFoundException {
        return getCreatedCurrentInstallations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    public List<CityDto> getCities() throws CityListNotFoundException {
        return getCreatedCurrentCities();
    }
}
