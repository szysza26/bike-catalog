package com.github.szysza26.bikecatalog.bike.controller;

import com.github.szysza26.bikecatalog.bike.dto.BikeDTO;
import com.github.szysza26.bikecatalog.bike.dto.BikeInListDTO;
import com.github.szysza26.bikecatalog.bike.model.Bike;
import com.github.szysza26.bikecatalog.bike.service.BikeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Set<BikeInListDTO>> index() {
        Set<BikeInListDTO> bikes = bikeService.getAllBikes();
        return new ResponseEntity<>(bikes, HttpStatus.OK);
    }

    @GetMapping("/api/bikes/{id}")
    public ResponseEntity<BikeDTO> show(@PathVariable Long id) {
        BikeDTO bike = bikeService.getBikeById(id);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    @PostMapping("/api/bikes")
    public ResponseEntity<BikeDTO> create(@Valid @RequestBody BikeDTO bike) {
        bike = bikeService.addBike(bike);
        return new ResponseEntity<>(bike, HttpStatus.CREATED);
    }

    @PutMapping("/api/bikes/{id}")
    public ResponseEntity<BikeDTO> update(@Valid @RequestBody BikeDTO bike, @PathVariable Long id) {
        bike = bikeService.updateBike(bike, id);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    @DeleteMapping("/api/bikes/{id}")
    public ResponseEntity<Bike> delete(@PathVariable Long id) {
        bikeService.deleteBike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
