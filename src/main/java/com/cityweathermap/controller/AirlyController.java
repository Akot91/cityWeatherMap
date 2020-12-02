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

    public List<CurrentDto> getCreatedCurrentInstallations() {
        if (currentInstallations.getCurrentDtos().isEmpty()) {
            currentInstallations.createCurrentDtos(airlyClient.getInstallations());
        }
        return currentInstallations.getCurrentDtos();
    }

    public List<CityDto> getCreatedCurrentCities() {
        if (currentInstallations.getCityDtos().isEmpty()) {
            currentInstallations.createCityDtos(airlyClient.getCities());
        }
        return currentInstallations.getCityDtos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public List<CurrentDto> getInstallations() {
        return getCreatedCurrentInstallations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    public List<CityDto> getCities() {
        return getCreatedCurrentCities();
    }
}
