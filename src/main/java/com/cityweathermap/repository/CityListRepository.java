package com.cityweathermap.repository;

import com.cityweathermap.domain.CityList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityListRepository extends CrudRepository<CityList, Long> {

    @Override
    List<CityList> findAll();

    @Override
    Optional<CityList> findById(Long id);

    @Override
    CityList save(CityList cityList);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
