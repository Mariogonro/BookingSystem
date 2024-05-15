package com.ada.BookingSystem.repository;

import com.ada.BookingSystem.repository.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepository  extends MongoRepository<User, String>
{
    Optional<User> findByEmail(String email );
}
