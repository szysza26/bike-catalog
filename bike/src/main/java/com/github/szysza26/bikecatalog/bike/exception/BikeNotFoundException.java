package com.github.szysza26.bikecatalog.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BikeNotFoundException extends RuntimeException{
}
