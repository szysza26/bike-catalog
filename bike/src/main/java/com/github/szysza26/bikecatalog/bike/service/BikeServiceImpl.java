package com.github.szysza26.bikecatalog.bike.service;

import com.github.szysza26.bikecatalog.bike.dto.BikeDTO;
import com.github.szysza26.bikecatalog.bike.dto.BikeInListDTO;
import com.github.szysza26.bikecatalog.bike.exception.BikeNotFoundException;
import com.github.szysza26.bikecatalog.bike.model.Bike;
import com.github.szysza26.bikecatalog.bike.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BikeServiceImpl implements BikeService {
    private BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public Set<BikeInListDTO> getAllBikes() {
        return bikeRepository.findAll().stream()
                .map(BikeInListDTO::new).collect(Collectors.toSet());
    }

    @Override
    public BikeDTO getBikeById(Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new BikeNotFoundException(id));
        return new BikeDTO(bike);
    }

    @Override
    public BikeDTO addBike(BikeDTO bikeDTO) {
        Bike bike = new Bike();
        bike.setName(bikeDTO.getName());
        bike.setDescription(bikeDTO.getDescription());
        bike = bikeRepository.save(bike);
        return new BikeDTO(bike);
    }

    @Override
    public BikeDTO updateBike(BikeDTO bikeDTO, Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new BikeNotFoundException(id));
        bike.setName(bikeDTO.getName());
        bike.setDescription(bikeDTO.getDescription());
        bike = bikeRepository.save(bike);
        return new BikeDTO(bike);
    }

    @Override
    public void deleteBike(Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new BikeNotFoundException(id));
        bikeRepository.delete(bike);
    }
}
