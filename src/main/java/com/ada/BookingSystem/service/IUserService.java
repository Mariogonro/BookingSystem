package com.ada.BookingSystem.service;

import com.ada.BookingSystem.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    List<User> all();
    Optional<User> findById(String id);
    void deleteById(String id);
    User save(User user);
}