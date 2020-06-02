package com.dev.spring;

import com.dev.spring.config.AppConfig;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User alice = new User("alice@ukr.net", "1234");
        User bob = new User("bob@ukr.net", "123456");
        userService.add(alice);
        userService.add(bob);
        userService.listUsers().forEach(user -> System.out.println(user.toString()));
    }
}
