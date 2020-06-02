package com.dev.spring.dao;

import com.dev.spring.model.User;
import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> listUsers();
}
