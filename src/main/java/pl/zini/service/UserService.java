package pl.zini.service;


import pl.zini.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    void saveUser(User user);
}