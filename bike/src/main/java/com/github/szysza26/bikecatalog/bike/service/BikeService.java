package com.github.szysza26.bikecatalog.bike.service;

import com.github.szysza26.bikecatalog.bike.dto.BikeDTO;
import com.github.szysza26.bikecatalog.bike.dto.BikeInListDTO;

import java.util.Set;

public interface BikeService {
    Set<BikeInListDTO> getAllBikes();
    BikeDTO getBikeById(Long id);
    BikeDTO addBike(BikeDTO bikeDTO);
    BikeDTO updateBike(BikeDTO bikeDTO, Long id);
    void deleteBike(Long id);
}
