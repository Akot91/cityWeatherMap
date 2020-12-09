package com.cityweathermap.mapper;

import com.cityweathermap.domain.CityList;
import com.cityweathermap.domain.CityListDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityListMapper {

    public CityList mapToCityList(final CityListDto cityListDto) {
        return new CityList(cityListDto.getId(),
                cityListDto.getName(),
                cityListDto.getCityIds());
    }

    public CityListDto mapToCityListDto(final CityList cityList) {
        return new CityListDto(cityList.getId(),
                cityList.getName(),
                cityList.getCityIds());
    }

    public List<CityListDto> mapToCityListsDto(final List<CityList> cityLists) {
        return cityLists.stream()
                .map(cityList -> new CityListDto(cityList.getId(), cityList.getName(), cityList.getCityIds()))
                .collect(Collectors.toList());
    }
}
