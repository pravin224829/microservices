package com.hotel.userservice.service;

import com.hotel.userservice.entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGSSERVICE/microservices/ratings")
public interface RatingsService {
    @GetMapping("/user/{user}")
    public List<Ratings> ratings(@PathVariable Long user);
}
