package com.hotel.ratingsservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ratings", nullable = false)
    private String ratings;

    @Column(name = "user_id", nullable = false, unique = false)
    private long user;

    @Column(name = "hotel_id", nullable = false, unique = false)
    private long hotel;

    @Column(name = "feedback", nullable = false)
    private String feedback;
@Transient
    private Hotel hotel1;

}