package com.example.demohibernateproblem.service;

import com.example.demohibernateproblem.dto.UserDTO;
import com.example.demohibernateproblem.entity.UserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

@Service
public class UserQueryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDTO getUserDTO(String id) {
//        TypedQuery<UserDetails> userQuery = entityManager.createQuery("SELECT u from UserDetails u where u.id=:id", UserDetails.class);
//        Query nameQuery = entityManager.createNamedQuery("UserEntity.findByUserId");
//        nameQuery.setParameter("userId", id);
        Query nativeQuery  = entityManager.createNativeQuery("SELECT * from user_details WHERE id=:userId", UserDetails.class);
        nativeQuery.setParameter("userId", id);
        UserDetails userDetails = (UserDetails)nativeQuery.getSingleResult();
        UserDTO userDTO = new UserDTO(userDetails);
        return userDTO;
    }
}
