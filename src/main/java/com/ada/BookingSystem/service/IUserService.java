package com.ada.BookingSystem.service;

import com.ada.BookingSystem.controller.user.UserDto;
import com.ada.BookingSystem.exception.UserNotFoundException;
import com.ada.BookingSystem.repository.entity.User;


import java.util.List;

public interface IUserService {

    User create( UserDto userDto );

    User findById( String id )
            throws UserNotFoundException;

    User findByEmail( String email )
            throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}