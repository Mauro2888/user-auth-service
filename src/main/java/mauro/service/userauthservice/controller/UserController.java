package mauro.service.userauthservice.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mauro.service.userauthservice.entity.User;
import mauro.service.userauthservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public List<User> getAll(){
    return userService.getAll();
  }

  @PostMapping("save")
  public ResponseEntity<User>saveUser(@RequestBody User userDto){
    User user = userService.saveUser(userDto);
    return ResponseEntity.ok(user);
  }

  @GetMapping("/admin")
  public String admin(){
    return "admin";
  }

  @GetMapping("/user")
  public String user(){
    return "user";
  }

}
