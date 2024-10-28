package com.hotel.ratingsservice.repository;

import com.hotel.ratingsservice.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Ratings, Long> {
    List<Ratings> findByHotel(Long hotel_id);
    List<Ratings> findByUser(Long user_id);
}