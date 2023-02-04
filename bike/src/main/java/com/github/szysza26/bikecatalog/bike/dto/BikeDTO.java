package com.github.szysza26.bikecatalog.bike.dto;

import com.github.szysza26.bikecatalog.bike.model.Bike;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BikeDTO {
    private Long id;
    @NotEmpty(message = "Name field is required.")
    @Size(min = 1, message = "Name is to short.")
    @Size(max = 50, message = "Name is to long.")
    private String name;
    @NotEmpty(message = "Description field is required.")
    @Size(min = 1, message = "Description is to short.")
    @Size(max = 255, message = "Description is to long.")
    private String description;

    public BikeDTO() { }

    public BikeDTO(Bike bike) {
        this.id = bike.getId();
        this.name = bike.getName();
        this.description = bike.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
