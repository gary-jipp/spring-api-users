package api.demo.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import api.demo.api.model.User;
import api.demo.service.UserService;

@RestController
public class UserController {
  private UserService userService;

  // @Autowired  // Not needed since only 1 constructor
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
  public ResponseEntity<User> addUser(@RequestBody User user) {
    User savedUser = userService.addUser(user);

    // Build the Location URI for the created resource
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();

    return ResponseEntity.created(location).body(savedUser);
  }

}
