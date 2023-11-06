package com.company.security;


import com.company.entity.Users;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user=userService.getByUsername(email);
        if (user != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(user.getPasswordhash());

            String[] authoritiesArr = {user.getUsertype()};
            builder.authorities(authoritiesArr);

            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

    }
}
