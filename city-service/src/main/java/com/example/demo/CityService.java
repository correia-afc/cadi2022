package com.example.demo;

import java.util.List;

public interface CityService {

    public List<City> getAll();

    public City getCity(Long id);

    public City create(City city);

}
