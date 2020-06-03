package com.dev.spring.controller;

import com.dev.spring.UserResponseDto;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectData() {
        userService.add(new User("alice@ukr.net", "1232"));
        userService.add(new User("bob@ukr.net", "1234"));
        userService.add(new User("john@ukr.net", "1235"));
        userService.add(new User("mark@ukr.net", "1236"));
        return "Data were injected";
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getEmail(), user.getPassword());
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        return users.stream()
                .map(user -> new UserResponseDto(user.getEmail(), user.getPassword()))
                .collect(Collectors.toList());
    }
}
