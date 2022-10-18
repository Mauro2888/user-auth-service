package mauro.service.userauthservice.sample;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ext", url = "https://reqbin.com/echo/get")
public interface ExternalApi {

  @RequestMapping(method = GET,
      value = "/json")
  ResponseEntity<Object> json();
}
