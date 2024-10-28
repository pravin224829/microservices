package com.hotel.ratingsservice.service;

import com.hotel.ratingsservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE/microservices/hotel")
public interface HotelService {
    @GetMapping("/id/{id}")
    public Hotel getHotel(@PathVariable Long id) ;
}
