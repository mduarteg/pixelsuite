package com.mx.pixelsoft.pixelsuite.service;

import com.mx.pixelsoft.pixelsuite.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static long idCount = 0;

    static {
        users.add(new User(++idCount, "UserOne"));
        users.add(new User(++idCount, "UserTwo"));
        users.add(new User(++idCount, "UserThree"));
        users.add(new User(++idCount, "UserFour"));
        users.add(new User(++idCount, "UserFive"));
    }

    public List<User> findAll() {
        return users;
    }
}
