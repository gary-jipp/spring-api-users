package api.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.demo.api.model.User;
import api.demo.api.repository.UserRepository;

@Service
public class UserService {

  @Autowired  // Not needed if using only one constructor
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUser(Integer id) {
    return userRepository.findById(id);
  }

  public List<User> getUsersByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }
}
