package com.example.demohibernateproblem.dto;

import com.example.demohibernateproblem.entity.UserDetails;

import java.util.List;
import java.util.UUID;

public class UserDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String name;
    private String email;
    private UUID id;

    public List<AddressDTO> getAddressDTOS() {
        return addressDTOS;
    }

    public void setAddressDTOS(List<AddressDTO> addressDTOS) {
        this.addressDTOS = addressDTOS;
    }

    List<AddressDTO> addressDTOS;
//    private S

    public UserDTO(UserDetails userDetails) {
        this.name = userDetails.getName();
        this.email = userDetails.getEmail();
        this.id = userDetails.getId();
        this.addressDTOS = userDetails.getAddresses().stream().map(AddressDTO::new).toList();

    }
}
