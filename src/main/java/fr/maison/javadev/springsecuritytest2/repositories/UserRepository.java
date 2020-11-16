package fr.maison.javadev.springsecuritytest2.repositories;

import fr.maison.javadev.springsecuritytest2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
