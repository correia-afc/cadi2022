package com.example.demo;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<?> getCities() {
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCity(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCity(@RequestBody City city) {
        City newCity = cityService.create(city);
        return ResponseEntity.created(URI.create("/cities/" + newCity.getId())).build();
    }

    @PutMapping(name = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCity(@PathVariable Long id, @RequestBody City city) {
        cityService.update(id, city);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
