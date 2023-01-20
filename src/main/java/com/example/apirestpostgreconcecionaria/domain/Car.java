package com.example.apirestpostgreconcecionaria.domain;


import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria id tipo Long autoincremetal")
    @Column(name = "ID")
    private Long id;

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "model")
    private String model;

    @Column(name = "cc")
    private Double cc;

    @Column(name = "doors")
    private Integer doors;

    @Column(name = "year")
    private Integer year;
    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "available")
    private boolean available;

//constructores
    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Double getCc() {
        return cc;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getYear() {
        return year;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", cc=" + cc +
                ", doors=" + doors +
                ", year=" + year +
                ", releaseDate=" + releaseDate +
                ", available=" + available +
                '}';
    }
}
