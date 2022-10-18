package mauro.service.userauthservice.sample;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-auth-service", url = "http://localhost:5000")
public interface SampleClient {

  @RequestMapping(method = GET,
                  value = "/users",
  produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object>getUsers();

}
