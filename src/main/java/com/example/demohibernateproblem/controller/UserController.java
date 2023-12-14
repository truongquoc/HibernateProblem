package com.example.demohibernateproblem.controller;

import com.example.demohibernateproblem.dto.UserDTO;
import com.example.demohibernateproblem.entity.UserDetails;
import com.example.demohibernateproblem.repository.UserDetailsRepository;
import com.example.demohibernateproblem.service.UserQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserQueryImpl userQuery;

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

    @GetMapping("/{id}")
    public ResponseEntity userDetails(@PathVariable String id) {
//        UserDTO userDTO = userQuery.getUserDTO(id);
        UserDetails userDetails = this.userDetailsRepository.findByUserId(id);
        UserDTO userDTO = new UserDTO(userDetails);
        return ResponseEntity.ok(userDTO);
    }
}
