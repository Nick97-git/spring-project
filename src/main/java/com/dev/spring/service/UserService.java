package com.dev.spring.service;

import com.dev.spring.model.User;
import java.util.List;

public interface UserService {

    void add(User user);

    List<User> listUsers();
}
