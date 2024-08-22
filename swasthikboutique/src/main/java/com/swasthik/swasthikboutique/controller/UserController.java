package com.swasthik.swasthikboutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swasthik.swasthikboutique.model.UserDetails;
import com.swasthik.swasthikboutique.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails user) {
        UserDetails savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<List<UserDetails>> getUserByFirstName(@PathVariable String firstName) {
        List<UserDetails> users = userService.findUserByFirstName(firstName);
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no users are found
        }
        return ResponseEntity.ok(users); // Return 200 OK with the list of users
    }

}
