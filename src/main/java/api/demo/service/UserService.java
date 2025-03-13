package api.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.demo.api.model.User;
import api.demo.api.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> getUser(Integer id) {
    return userRepository.findById(id);
  }

  public List<User> getUsersByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
