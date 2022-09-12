package zt.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zt.config.SpringConfigration;
import zt.service.UserService;

public class UserController {
    public static void main(String[] args) {
         // ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml"); // 加载配置文件用
        // 注解的方式
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
        System.out.println(UserService.class);
    }
}
