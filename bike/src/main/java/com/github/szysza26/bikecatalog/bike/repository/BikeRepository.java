package com.github.szysza26.bikecatalog.bike.repository;

import com.github.szysza26.bikecatalog.bike.model.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {
    Set<Bike> findAll();
}
