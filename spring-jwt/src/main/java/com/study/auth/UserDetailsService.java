package com.study.auth;

import com.study.repository.UserLoginService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserLoginService userLoginService;

    @PostConstruct
    public void init() {
        this.userLoginService = new UserLoginService();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userLoginService.exists(username)) {
            return new User(username, userLoginService.getUser().getPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }
}
