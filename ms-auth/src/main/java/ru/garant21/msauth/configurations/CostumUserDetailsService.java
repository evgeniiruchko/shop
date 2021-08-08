package ru.garant21.msauth.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.garant21.msauth.enteties.User;
import ru.garant21.msauth.services.UserService;

@Component
public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CostumUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(username);
        return CostumUserDetails.fromUserEntityToCostumUserDetailes(user);
    }
}
