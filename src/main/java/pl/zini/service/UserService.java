package pl.zini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zini.model.User;
import pl.zini.repository.UserRepository;
import pl.zini.web.dto.UserRegistrationDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    User getById(Long id);

    List<User> findAll();

    void delete(User user);
}