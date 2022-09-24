package zt1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zt1.config.SpringConfigration;
import zt1.service.UserService;

public class test {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();

    }
}
