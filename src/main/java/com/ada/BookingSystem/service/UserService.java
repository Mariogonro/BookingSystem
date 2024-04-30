package com.ada.BookingSystem.service;


import com.ada.BookingSystem.repository.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private static final Map<Integer, User> userRepository = new HashMap<>();
    public List<User> getAllUser() {
        return new ArrayList<>(userRepository.values());
    }

    public User getById(int userId) {
        return userRepository.get(userId);
    }

    public User createUser(User user) {
        if (userRepository.containsKey(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        userRepository.put(user.getId(), user);
        return user;
    }

    public User updateUser(int userId, User user) {

        if (!userRepository.containsKey(userId)) {
            throw new RuntimeException("User does not exist");
        }
        userRepository.put(user.getId(), user);
        return user;
    }

    public void deleteUser(int userId) {
        if (userRepository.containsKey(userId)) {
            userRepository.remove(userId);
        }
    }
}
