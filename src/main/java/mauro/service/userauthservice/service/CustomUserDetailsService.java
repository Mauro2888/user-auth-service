package mauro.service.userauthservice.service;

import lombok.RequiredArgsConstructor;
import mauro.service.userauthservice.entity.User;
import mauro.service.userauthservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username);
      if (username == null || username.isEmpty()) {
        throw new UsernameNotFoundException("Username is empty");
      }
      return new CustomUserDetails(user);
    }
}
