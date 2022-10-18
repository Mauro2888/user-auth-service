package mauro.service.userauthservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mauro.service.userauthservice.entity.Role;
import mauro.service.userauthservice.entity.User;
import mauro.service.userauthservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  @PostConstruct
  public void init(){
    User user = new User();
    user.setUsername("admin");
    user.setPassword("$2a$12$Xk7oi3kCvTh6us4oU18Q6Oqo.lzO7Uxoh.G4FMyx0pYgGY0Ky.AdG");
    Set<Role> roleSet =new HashSet<>();
    Role role = new Role();
    role.setRoleName("ADMIN");
    roleSet.add(role);
    user.setRoles(roleSet);
    userRepository.save(user);

    User user2 = new User();
    user2.setUsername("user");
    user2.setPassword("$2a$12$G4w5CzUQtWwrIPwfjvzK5ufz.DHSPSi7SOWa512hBz5PRV85m3wXe");
    Set<Role> roleSet2 =new HashSet<>();
    Role role2 = new Role();
    role2.setRoleName("USER");
    roleSet2.add(role2);
    user2.setRoles(roleSet2);
    userRepository.save(user2);
  }

  public User saveUser(User user) {
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    return userRepository.save(user);
  }

  public List<User> getAll(){
    return userRepository.findAll();
  }
}
