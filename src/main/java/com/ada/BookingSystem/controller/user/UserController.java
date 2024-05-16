package com.ada.BookingSystem.controller.user;

import com.ada.BookingSystem.repository.entity.User;
import com.ada.BookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userService.all();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        User user  = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        URI createdUserUri = URI.create("");
        User user = userService.create(userDto);
        return ResponseEntity.created(createdUserUri).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        User user = userService.update( userDto, id );
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }
}