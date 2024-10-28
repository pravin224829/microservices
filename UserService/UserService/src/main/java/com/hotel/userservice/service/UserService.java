package com.hotel.userservice.service;

import com.hotel.userservice.entity.User;
import com.hotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createUserService(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteByIdentity(Long id) {
        userRepository.deleteById(id);
    }
}
