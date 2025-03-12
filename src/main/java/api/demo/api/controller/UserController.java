package api.demo.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.demo.api.model.User;
import api.demo.service.UserService;

@RestController
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  public User getUser(@RequestParam Integer id) {
    Optional<User> user = userService.getUser(id);
    if (user.isPresent()) {
      return (User) user.get();
    }

    return null;
  }

}
