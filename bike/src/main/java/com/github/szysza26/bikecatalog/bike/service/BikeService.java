package com.github.szysza26.bikecatalog.bike.service;

import com.github.szysza26.bikecatalog.bike.model.Bike;

import java.util.Set;

public interface BikeService {
    Set<Bike> getAllBikes();
    Bike getBikeById(Long id);
    Bike addBike(Bike bike);
    Bike updateBike(Bike bike, Long id);
    void deleteBike(Long id);
}
