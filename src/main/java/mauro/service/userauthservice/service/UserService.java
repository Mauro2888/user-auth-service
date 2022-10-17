package mauro.service.userauthservice.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mauro.service.userauthservice.entity.User;
import mauro.service.userauthservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User saveUser(User user) {
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    return userRepository.save(user);
  }

  public List<User> getAll(){
    return userRepository.findAll();
  }
}
