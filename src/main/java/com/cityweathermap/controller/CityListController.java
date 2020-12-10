package com.cityweathermap.controller;

import com.cityweathermap.domain.CityListDto;
import com.cityweathermap.mapper.CityListMapper;
import com.cityweathermap.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cityList")
public class CityListController {

    @Autowired
    private DbService dbService;

    @Autowired
    private CityListMapper cityListMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/lists")
    public List<CityListDto> getCityLists() {
        return cityListMapper.mapToCityListsDto(dbService.getAllLists());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lists/{listId}")
    public CityListDto getCityList(Long listId) throws CityListNotFoundException {
        return cityListMapper.mapToCityListDto(dbService.findCityListById(listId).orElseThrow(CityListNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lists/size")
    public long getSize() {
        return dbService.size();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lists", consumes = APPLICATION_JSON_VALUE)
    public void createCityList(@RequestBody CityListDto cityListDto) {
        dbService.saveCityList(cityListMapper.mapToCityList(cityListDto));
    }
}
