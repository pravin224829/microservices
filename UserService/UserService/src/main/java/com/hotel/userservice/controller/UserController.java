package com.hotel.userservice.controller;

import com.hotel.userservice.entity.Ratings;
import com.hotel.userservice.entity.User;
import com.hotel.userservice.repository.UserRepository;
import com.hotel.userservice.service.RatingsService;
import com.hotel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/microservices/user")
public class UserController {
    @Autowired
    RatingsService ratingsService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user){
        User user1=userService.createUserService(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> user=userService.getAllUser();
        return new ResponseEntity<List<User>>(user,HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
       User user= userService.getById(id);
      List <Ratings> list=ratingsService.ratings(id);
       //List<Ratings>list=restTemplate.getForObject("http://RATINGSSERVICE/microservices/ratings/user/"+id, List.class);
       user.setRatings(list);
       return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Long id){
        userService.deleteByIdentity(id);
        return new ResponseEntity<String>("Record deleted",HttpStatus.OK);
    }
}
