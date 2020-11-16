package fr.maison.javadev.springsecuritytest2.services;

import fr.maison.javadev.springsecuritytest2.entities.User;
import fr.maison.javadev.springsecuritytest2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);

        User u = user.orElseThrow (()-> new UsernameNotFoundException("Error!"));

        return new SecurityUser(u);
    }
}
