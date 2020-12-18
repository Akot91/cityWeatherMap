package com.cityweathermap.mapper;

import com.cityweathermap.domain.CityList;
import com.cityweathermap.domain.CityListDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CityListMapperTestSuite {

    @Autowired
    private CityListMapper testee;

    @Test
    public void shouldReturnCityList() {
        //Given
        CityListDto cityListDto = new CityListDto(1L, "test_name", "5, 20");
        
        //When
        CityList result = testee.mapToCityList(cityListDto);

        //Then
        Assert.assertEquals(new Long(1L), result.getId());
        Assert.assertEquals("test_name", result.getName());
        Assert.assertEquals("5, 20", result.getCityIds());
    }

    @Test(expected = NullPointerException.class)
    public void mapToCityListShouldReturnException() {
        //Given When Then
        CityList result = testee.mapToCityList(null);
    }

    @Test
    public void shouldReturnCityListDto() {
        //Given
        CityList cityList = new CityList(2L, "city_test", "15, 32, 84");

        //When
        CityListDto result = testee.mapToCityListDto(cityList);

        //Then
        Assert.assertEquals(new Long(2L), result.getId());
        Assert.assertEquals("city_test", result.getName());
        Assert.assertEquals("15, 32, 84", result.getCityIds());
    }

    @Test(expected = NullPointerException.class)
    public void mapToCityListDtoShouldReturnException() {
        //Given When Then
        CityListDto result = testee.mapToCityListDto(null);
    }

    @Test
    public void shouldReturnCityListsDto() {
        //Given
        List<CityList> cityLists = new ArrayList<>();
        cityLists.add(new CityList(1L, "test", "1 ,2"));
        cityLists.add(new CityList(2L, "test2", "3, 4"));
        cityLists.add(new CityList(3L, "test3", "5,6"));

        //When
        List<CityListDto> result = testee.mapToCityListsDto(cityLists);

        //Then
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void shouldReturnEmptyList() {
        //Given
        List<CityList> cityLists = new ArrayList<>();

        //When
        List<CityListDto> result = testee.mapToCityListsDto(cityLists);

        //Then
        Assert.assertEquals(0, result.size());
    }

    @Test(expected = NullPointerException.class)
    public void mapToCityListsDtoShouldReturnException() {
        //Given When Then
        List<CityListDto> result = testee.mapToCityListsDto(null);
    }
}
