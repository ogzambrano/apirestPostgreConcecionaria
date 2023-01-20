package com.example.apirestpostgreconcecionaria.repository;


import com.example.apirestpostgreconcecionaria.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

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
