package com.example.CRUD.repository;

import com.example.CRUD.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    // 회원가입
    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    // user id 찾기
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // user name 찾기
    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    // 전체 유저 조회
    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }


    // Test 시 메모리 clear
    public void clearStore() {
        store.clear();
    }
}
