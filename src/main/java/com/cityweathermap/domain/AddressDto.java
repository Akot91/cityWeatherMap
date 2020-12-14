package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "street")
    private String street;

    public AddressDto() {
    }

    public AddressDto(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

}
