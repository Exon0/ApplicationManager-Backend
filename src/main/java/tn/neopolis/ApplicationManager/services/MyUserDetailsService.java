package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.DTO.MyUserLogin;
import tn.neopolis.ApplicationManager.models.User;
import tn.neopolis.ApplicationManager.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("ilyes","123", Collections.emptyList());
    }
*/

   @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserLogin(user);
    }
}