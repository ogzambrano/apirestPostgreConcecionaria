package com.example.apirestpostgreconcecionaria.service;

import com.example.apirestpostgreconcecionaria.domain.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarService {

    //spring repository methods

    List<Car> findAll();

    Optional<Car> findById(Long id);

    Long count();

    Car save(Car car);

    void deleteById(Long id);

    void deleteAll();

    void deleteAll(List<Car> cars);

    void deleteAllById(List<Long> ids);

    //custom methods

    List<Car> findByDoors(Integer doors);

    List<Car> findByManufacturerAndModel(String manufacturer, String model);

    List<Car> findByDoorsGreaterThanEqual(Integer doors);

    List<Car> findByModelContainig(String model);

    List<Car> findByYearIn(List<Integer> years);

    List<Car> findByYearBetween(Integer startYear, Integer endYear);

    List<Car> findByReleaseDateBetween(LocalDate starDate, LocalDate endDate);

    List<Car> findByAvalibleTrue();

    Long deleteAllByAvailabFalse();
}
