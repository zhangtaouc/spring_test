package zt.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zt.Service.UserService;
import zt.domain.User;

import java.io.IOException;
import java.util.List;

public class UserController {
    public static void main(String[] args) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        List<User> userList = userService.getAll();
        System.out.println(userList);
    }
}
