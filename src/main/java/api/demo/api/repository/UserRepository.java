package api.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.demo.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}