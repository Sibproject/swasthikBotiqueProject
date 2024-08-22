package com.swasthik.swasthikboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swasthik.swasthikboutique.model.UserDetails;
import com.swasthik.swasthikboutique.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public UserDetails saveUser(UserDetails user) {
        return userRepository.save(user);
    }

    public List<UserDetails> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDetails> findUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

}
