package com.cityweathermap.service;

import com.cityweathermap.domain.CityList;
import com.cityweathermap.repository.CityListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private CityListRepository cityListRepository;

    public List<CityList> getAllLists() {
        return cityListRepository.findAll();
    }

    public Optional<CityList> findCityListById(final Long id) {
        return cityListRepository.findById(id);
    }

    public CityList saveCityList(final CityList cityList) {
        return cityListRepository.save(cityList);
    }

    public void deleteCityList(final Long id) {
        cityListRepository.deleteById(id);
    }

    public long size() {
        return cityListRepository.count();
    }
}
