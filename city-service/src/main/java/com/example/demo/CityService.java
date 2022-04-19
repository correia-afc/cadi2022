package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City getCity(Long id) {
        return cityRepository.findById(id).orElseThrow();
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

}
