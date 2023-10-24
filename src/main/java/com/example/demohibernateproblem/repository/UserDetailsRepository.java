package com.example.demohibernateproblem.repository;

import com.example.demohibernateproblem.entity.UserDetails;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, UUID> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "UserDetails.addresses")
    List<UserDetails> findByNameContaining(String email);


//    @Query("select u from UserDetails u join fetch u.addresses")
//    List<UserDetails> findAll();
}
