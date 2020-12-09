package com.cityweathermap.domain;

public class CityListDto {

    private Long id;
    private String name;
    private String cityIds;

    public CityListDto(Long id, String name, String cityIds) {
        this.id = id;
        this.name = name;
        this.cityIds = cityIds;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityIds() {
        return cityIds;
    }
}
