package com.cityweathermap.domain;

import javax.persistence.*;

@Entity(name = "CityList")
public class CityList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cityIds")
    private String cityIds;

    public CityList() {}

    public CityList(Long id, String name, String cityIds) {
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
