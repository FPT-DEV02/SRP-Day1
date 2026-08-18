package com.userregistration.hashing;

public interface PasswordHasher {
    String hash(String rawPassword);
}
