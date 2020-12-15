package com.cityweathermap.controller;

import com.cityweathermap.airly.client.AirlyClient;
import com.cityweathermap.domain.CityDto;
import com.cityweathermap.domain.CurrentDto;
import com.cityweathermap.domain.CurrentInstallations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/airly/installations")
public class AirlyController {

    @Autowired
    private AirlyClient airlyClient;

    @Autowired
    private CurrentInstallations currentInstallations;

    public List<CurrentDto> getCreatedCurrentInstallations(Long id) throws CityListNotFoundException {
        if (currentInstallations.getCurrentDtos().isEmpty()) {
            currentInstallations.createCurrentDtos(airlyClient.getInstallations(id));
        }
        return currentInstallations.getCurrentDtos();
    }

    public List<CityDto> getAllCities() {
        if (currentInstallations.getAllCities().isEmpty()) {
            currentInstallations.createAllCities(airlyClient.getAllEnabledCities(currentInstallations.getAllCityIndexes()));
        }
        return currentInstallations.getAllCities();
    }

    public List<CityDto> getCreatedCurrentCities(Long id) throws CityListNotFoundException {
        if (currentInstallations.getCityDtos().isEmpty()) {
            currentInstallations.createCityDtos(airlyClient.getCities(id));
        }
        return currentInstallations.getCityDtos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chosenInstallations")
    public List<CurrentDto> getInstallations(@RequestParam Long id) throws CityListNotFoundException {
        return getCreatedCurrentInstallations(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chosenCities")
    public List<CityDto> getCities(@RequestParam Long id) throws CityListNotFoundException {
        return getCreatedCurrentCities(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allCities")
    public List<CityDto> getAllEnabledCities() {
            return getAllCities();
    }

}
