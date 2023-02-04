package com.github.szysza26.bikecatalog.bike.controller;

import com.github.szysza26.bikecatalog.bike.model.Bike;
import com.github.szysza26.bikecatalog.bike.service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/bikes/{id}")
    public ResponseEntity<Bike> show(@PathVariable Long id) {
        Bike bike = bikeService.getBikeById(id);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    @PostMapping("/api/bikes")
    public ResponseEntity<Bike> create(@RequestBody Bike bike) {
        bike = bikeService.addBike(bike);
        return new ResponseEntity<>(bike, HttpStatus.CREATED);
    }

    @PutMapping("/api/bikes/{id}")
    public ResponseEntity<Bike> update(@RequestBody Bike bike, @PathVariable Long id) {
        bike = bikeService.updateBike(bike, id);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    @DeleteMapping("/api/bikes/{id}")
    public ResponseEntity<Bike> delete(@PathVariable Long id) {
        bikeService.deleteBike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
