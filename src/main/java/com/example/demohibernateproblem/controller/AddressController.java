package com.example.demohibernateproblem.controller;

import com.example.demohibernateproblem.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    AddressRepository addressRepository;
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public ResponseEntity getAddressByCity(@RequestParam String city) {
        return ResponseEntity.ok(addressRepository.findAddressByCity(city));
    }
}
