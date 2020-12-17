package com.cityweathermap.airly.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AirlyConfigTestSuite {

    @Autowired
    private AirlyConfig airlyConfig;

    @Test
    public void shouldReturnAirlyApiKey() {
        //Given When
        String result = airlyConfig.getAirlyApiKey();

        // Then
        Assert.assertEquals("8wnhVgmtnchS3OFLBJiUYIrnLHiGJZw2", result);
    }

    @Test
    public void shouldReturnAirlyEndpoint() {
        //Given When
        String result = airlyConfig.getAirlyEndpoint();

        //Then
        Assert.assertEquals("https://airapi.airly.eu", result);
    }
}
