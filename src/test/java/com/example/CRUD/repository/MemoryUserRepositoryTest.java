package com.example.CRUD.repository;

import com.example.CRUD.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUserRepositoryTest {

    MemoryUserRepository repository = new MemoryUserRepository();

    // 순서와 상관없이 store를 지워준다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("민재");

        repository.save(user);

        User result = repository.findById(user.getId()).get();
        Assertions.assertThat(user).isEqualTo(result);
        System.out.println("result = " + (result == user));
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }
}