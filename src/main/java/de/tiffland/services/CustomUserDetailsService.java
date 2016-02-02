package de.tiffland.services;

import de.tiffland.entities.User;
import de.tiffland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Thomas on 01.02.16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username);
        if(user == null) throw new UsernameNotFoundException("Benutzer wurde nicht gefunden");
        return new MyUserDetails(user);
    }
}
