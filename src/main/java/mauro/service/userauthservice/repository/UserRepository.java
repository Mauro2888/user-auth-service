package mauro.service.userauthservice.repository;

import java.util.Optional;
import mauro.service.userauthservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);
    User findByUsername(String username);
}
