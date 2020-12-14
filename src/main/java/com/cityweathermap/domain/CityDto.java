package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {

    @JsonProperty(value = "address")
    private AddressDto adress;

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "locationId")
    private int locationId;

    public CityDto() {
    }

    public CityDto(AddressDto adress, int id, int locationId) {
        this.adress = adress;
        this.id = id;
        this.locationId = locationId;
    }

    public AddressDto getAdress() {
        return adress;
    }

    public int getId() {
        return id;
    }

    public int getLocationId() {
        return locationId;
    }
}
