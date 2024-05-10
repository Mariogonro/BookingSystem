package com.ada.BookingSystem.controller.user;

import com.ada.BookingSystem.repository.entity.User;
import com.ada.BookingSystem.service.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userService.all();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        Optional<User> user  = userService.findById(id);
        return ResponseEntity.ok(user.get());
    }
    @PostMapping
    public ResponseEntity<User> createProduct(@RequestBody User newUser) {
        URI createdUserUri = URI.create("");
        User user = userService.save(newUser);
        return ResponseEntity.created(createdUserUri).body(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }
}