package main.java.account.service;

import main.java.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
