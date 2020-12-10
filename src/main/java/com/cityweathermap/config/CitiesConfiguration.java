package com.cityweathermap.config;

import com.cityweathermap.domain.CityList;
import com.cityweathermap.domain.CityListDto;
import com.cityweathermap.mapper.CityListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CitiesConfiguration {

    @Autowired
    private CityListMapper cityListMapper;

    private List<Integer> cities;

    public void createNewConfiguration(CityListDto cityListDto) {
        CityList list = cityListMapper.mapToCityList(cityListDto);
        List<String> test = Arrays.asList(list.getCityIds().split(", "));
        cities = new ArrayList<>();
        for (String s : test) {
            cities.add(Integer.valueOf(s));
        }
    }

    public List<Integer> getCities() {
        return cities;
    }
}
