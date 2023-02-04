package com.github.szysza26.bikecatalog.bike.controller;

import com.github.szysza26.bikecatalog.bike.model.Bike;
import com.github.szysza26.bikecatalog.bike.service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BikeController {
    private BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/api/bikes")
    public ResponseEntity<Set<Bike>> index() {
        Set<Bike> bikes = bikeService.getAllBikes();
        return new ResponseEntity<>(bikes, HttpStatus.OK);
    }
}
