package com.hotel.hotelservice.service;

import com.hotel.hotelservice.entity.Hotel;
import com.hotel.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    public Hotel createHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    public List<Hotel> allHotels(){
        return hotelRepository.findAll();
    }
    public Hotel findById(Long id){
        return hotelRepository.findById(id).get();
    }

    //service annotation remaining
}
