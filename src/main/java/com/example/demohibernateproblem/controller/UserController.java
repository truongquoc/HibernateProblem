package com.example.demohibernateproblem.controller;

import com.example.demohibernateproblem.dto.UserDTO;
import com.example.demohibernateproblem.entity.UserDetails;
import com.example.demohibernateproblem.repository.UserDetailsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDetailsRepository userDetailsRepository;

    public UserController(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @GetMapping
    public ResponseEntity hello() {
        try {
            List<UserDetails> userDetails = userDetailsRepository.findAll();
            return ResponseEntity.ok(userDetails.stream().map(UserDTO::new));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
