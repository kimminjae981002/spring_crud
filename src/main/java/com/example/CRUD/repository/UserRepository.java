package com.example.CRUD.repository;

import com.example.CRUD.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();
    Optional<User> deleteUser(String name);
}
