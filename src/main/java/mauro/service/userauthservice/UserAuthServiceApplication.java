package mauro.service.userauthservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableFeignClients
public class UserAuthServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserAuthServiceApplication.class, args);
  }


}
