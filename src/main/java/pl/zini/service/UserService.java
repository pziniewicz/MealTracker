package pl.zini.service;

import pl.zini.model.User;

public interface UserService {
    User findByEmail(String email);

    void saveUser(User user);
}
