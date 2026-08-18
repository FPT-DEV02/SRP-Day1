package com.userregistration.repository;

import com.userregistration.model.User;

public interface UserRepository {
    User save(User user);
}
