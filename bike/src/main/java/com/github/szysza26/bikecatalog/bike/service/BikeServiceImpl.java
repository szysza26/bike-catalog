package com.github.szysza26.bikecatalog.bike.service;

import com.github.szysza26.bikecatalog.bike.exception.BikeNotFoundException;
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

    @Override
    public Bike getBikeById(Long id) {
        return bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
    }

    @Override
    public Bike addBike(Bike bikeDTO) {
        return bikeRepository.save(bikeDTO);
    }

    @Override
    public Bike updateBike(Bike bikeDTO, Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
        bike.setName(bikeDTO.getName());
        bike.setDescription(bikeDTO.getDescription());
        return bikeRepository.save(bike);
    }

    @Override
    public void deleteBike(Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
        bikeRepository.delete(bike);
    }
}
