package com.hotel.ratingsservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
    @Column(name = "hotel_id", nullable = false)
    private Long hotel_id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "ratings", nullable = false, unique = true)
    private Long ratings;

}