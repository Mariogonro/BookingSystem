package com.ada.BookingSystem.repository.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    private boolean enabled;

}
