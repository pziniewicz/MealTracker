package pl.zini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zini.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
