package com.example.CRUD.service;

import com.example.CRUD.domain.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public User registerUser(User user) {
        Optional<User> result = userRepository.findByName(user.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        return userRepository.save(user);
    }
    
    // user id 찾기
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // user name 찾기
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    // 전체 유저 조회
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
