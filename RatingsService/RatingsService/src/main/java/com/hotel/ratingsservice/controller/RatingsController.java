package com.hotel.ratingsservice.controller;

import com.hotel.ratingsservice.entity.Hotel;
import com.hotel.ratingsservice.entity.Ratings;
import com.hotel.ratingsservice.service.HotelService;
import com.hotel.ratingsservice.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/microservices/ratings")
public class RatingsController {
    @Autowired
    HotelService hotelService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
            Ratings rat1;

    RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    @PostMapping
    public ResponseEntity<Ratings>createRatings(@RequestBody Ratings ratings){
        Ratings ratings1=ratingsService.createRatings(ratings);
    return new ResponseEntity<>(ratings1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Ratings>>findAllRatings(){
       List <Ratings> ratings=ratingsService.getAll();
        return new ResponseEntity(ratings,HttpStatus.OK);
    }
    @GetMapping("/hotel")
    public ResponseEntity<Ratings> findByHotel(@RequestParam Long hotel){
       List <Ratings> ratings2=ratingsService.findAllByHotel(hotel);
       return new ResponseEntity(ratings2,HttpStatus.OK);
    }
    @GetMapping("/user/{user}")
    public ResponseEntity<Map<Ratings,Hotel>>findByUser(@PathVariable Long user){
        List<Ratings> ratings=ratingsService.findByUserid(user);
        List<Long>hotelId=ratings.stream().map(Ratings::getHotel).collect(Collectors.toList());
        Iterator <Long> itr=hotelId.iterator();
        //Map<Integer,Ratings> ratingsMap=new HashMap<>();
        List<Ratings>list=new ArrayList<>();
        Iterator<Ratings> itr2=ratings.iterator();
        while (itr.hasNext()){
            int i=1;
            while(itr2.hasNext()) {//both unique ids hotel and rating
                rat1 = itr2.next();

                rat1.setHotel1(restTemplate.getForObject("http://HOTELSERVICE/microservices/hotel/id/" + itr.next(), Hotel.class));
                //ratingsMap.put(i, rat1);
                list.add(rat1);
                i++;
            }

        }
        //System.out.println(ratingsMap);
       // return new ResponseEntity(ratingsMap,HttpStatus.OK);
        return new ResponseEntity(list,HttpStatus.OK);

    }

}
