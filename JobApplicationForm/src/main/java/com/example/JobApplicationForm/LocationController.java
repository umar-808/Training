/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JobApplicationForm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kalsym
 */
@RestController
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @GetMapping("/location")
    public List<Location> list() {
        return repository.findAll();
    }

    @GetMapping("location/{id}")
    public ResponseEntity<Location> get(@PathVariable Long id) {
        Location location = repository.findById(id).get();
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    @PostMapping("/location")
    public void add(@RequestBody Location location) {
        repository.save(location);
    }
}
