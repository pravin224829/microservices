package com.hotel.hotelservice.controller;

import com.hotel.hotelservice.entity.Hotel;
import com.hotel.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microservices/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel>saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1=hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>>findAllHotels(){
        List<Hotel>hotel=hotelService.allHotels();
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Hotel> getRatingsById(@PathVariable Long id){
        Hotel hotel=hotelService.findById(id);
        return new ResponseEntity(hotel,HttpStatus.OK);
    }

}
