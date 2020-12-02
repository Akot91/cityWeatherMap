package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {

    @JsonProperty(value = "address")
    private AddressDto adress;

    public CityDto() {
    }

    public CityDto(AddressDto adress) {
        this.adress = adress;
    }

    public AddressDto getAdress() {
        return adress;
    }
}
