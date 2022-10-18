package mauro.service.userauthservice.security;

import javax.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public AuthenticationProvider provider (){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(new BCryptPasswordEncoder());
    return provider;
  }

  @Bean
  WebSecurityCustomizer webChain() {
    return (WebSecurity web) -> web.ignoring().antMatchers("/api/**");
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf().disable();
    httpSecurity
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/save").permitAll()
        .antMatchers("/users").permitAll()
        .antMatchers("/api").permitAll()
        .antMatchers("/h2/**").permitAll()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
        .anyRequest().authenticated()
        .and().httpBasic();
    httpSecurity.headers().frameOptions().disable();
    return httpSecurity.build();
  }
}
