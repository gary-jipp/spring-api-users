package api.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user")
  public User getUser(@RequestParam Integer id) {
    Optional<User> user = userService.getUser(id);
    if (user.isPresent()) {
      return (User) user.get();
    }
    return null;
  }

  @GetMapping("/user/{id}")
  public User getUserPath(@PathVariable Integer id) {
    Optional<User> user = userService.getUser(id);
    if (user.isPresent()) {
      return (User) user.get();
    }
    return null;
  }

  // Endpoint to find users by email
  @GetMapping("/email/{email}")
  public List<User> getUserByEmail(@PathVariable String email) {
    return userService.getUsersByEmail(email);
  }

  @PostMapping("/users")
  public User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

}
