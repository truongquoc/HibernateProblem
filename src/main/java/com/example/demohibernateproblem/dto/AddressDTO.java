package com.example.demohibernateproblem.dto;

import com.example.demohibernateproblem.entity.Address;

public class AddressDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressDTO(Address address) {
        this.name = address.getAddress1();
        this.city = address.getCity();
    }

    String name;
    String city;
}
