package api.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.demo.api.model.User;

@Service
public class UserService {
  private Map<Integer, User> userMap;

  public UserService() {
    // Mock User Data
    this.userMap = new HashMap<Integer, User>();
    User user1 = new User(1, "Alice", "alice@demo.com");
    User user2 = new User(2, "Bob", "bob@demo.com");
    User user3 = new User(3, "Carol", "carol@demo.com");
    User user4 = new User(4, "Dean", "dean@demo.com");

    this.userMap.put(user1.getId(), user1);
    this.userMap.put(user2.getId(), user2);
    this.userMap.put(user3.getId(), user3);
    this.userMap.put(user4.getId(), user4);
  }

  public Optional<User> getUser(Integer id) {
    User user = this.userMap.get(id);
    if (user != null) {
      return Optional.of(user);
    }

    return Optional.empty();
  }

}
