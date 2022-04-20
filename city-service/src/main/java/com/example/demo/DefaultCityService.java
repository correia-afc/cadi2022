package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class DefaultCityService implements CityService{

    private CityRepository cityRepository;

    public DefaultCityService(CityRepository cityRepository) {
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

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    public void update(Long id, City city) {
        cityRepository.findById(id).ifPresentOrElse(c -> {
            city.setId(id);
            cityRepository.save(city);
        }, () -> {
            throw new NoSuchElementException();
        });
    }
}
