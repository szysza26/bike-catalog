package com.github.szysza26.bikecatalog.bike.service;

import com.github.szysza26.bikecatalog.bike.model.Bike;
import com.github.szysza26.bikecatalog.bike.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BikeServiceImpl implements BikeService {
    private BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public Set<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }
}
