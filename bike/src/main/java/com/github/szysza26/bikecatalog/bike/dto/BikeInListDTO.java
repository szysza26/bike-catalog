package com.github.szysza26.bikecatalog.bike.dto;

import com.github.szysza26.bikecatalog.bike.model.Bike;

public class BikeInListDTO {
    private Long id;
    private String name;

    public BikeInListDTO() {}

    public BikeInListDTO(Bike bike) {
        this.id = bike.getId();
        this.name = bike.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
