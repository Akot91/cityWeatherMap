package com.cityweathermap.config;

import com.cityweathermap.domain.CityListDto;
import com.cityweathermap.mapper.CityListMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CitiesConfigurationTestSuite {

    @Autowired
    private CityListMapper cityListMapper;

    @Autowired
    private CitiesConfiguration testee;

    @Test
    public void shouldReturnCitiesList() {
        //Given
        CityListDto cityListDto = new CityListDto(2L, "test", "26, 15, 84, 22, 30");

        //When
        testee.createNewConfiguration(cityListDto);
        List<Integer> result = testee.getCities();

        //Then
        Assert.assertEquals(5, result.size());
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnException() {
        //Given When Then
        testee.createNewConfiguration(null);
    }
}
