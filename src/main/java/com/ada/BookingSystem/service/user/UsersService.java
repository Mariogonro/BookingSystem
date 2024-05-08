package com.ada.BookingSystem.service.user;

import com.ada.BookingSystem.repository.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {

    User save(User user);

    User findById(int id);

    List<User> all();

    void deleteById(int id);

    User update( int userId,User user);
}