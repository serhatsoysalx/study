package com.study.repository;


import com.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    private User user;

    private BCryptPasswordEncoder passwordEncoder; // Autowired ile enjekte edildi

    public UserLoginService() {
        passwordEncoder = new BCryptPasswordEncoder();
        this.user = new User("serhat", passwordEncoder.encode("123"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean exists(String username) {
        return user.getUsername().equals(username);
    }

}
