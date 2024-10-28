package com.hotel.ratingsservice.service;

import com.hotel.ratingsservice.entity.Ratings;
import com.hotel.ratingsservice.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public RatingsService() {
        this.ratingsRepository = ratingsRepository;
    }
    public Ratings createRatings(Ratings ratings){
        return ratingsRepository.save(ratings);
    }
    public List<Ratings> getAll(){
        return ratingsRepository.findAll();
    }
    public List<Ratings> findAllByHotel(Long id){
        return ratingsRepository.findByHotel(id);
    }
    public List<Ratings> findByUserid(Long user_id){
        return ratingsRepository.findByUser(user_id);
    }
}
