package com.userregistration.repository;

import com.userregistration.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }
}
