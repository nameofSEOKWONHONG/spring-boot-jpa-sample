package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public User getLoginUserByLoginId(String loginId) {
        return new User(1, "test@test.com", "test");
    }
}
