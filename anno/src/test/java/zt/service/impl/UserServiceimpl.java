package zt.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import zt.service.UserService;

import javax.annotation.Resource;
//<bean id="userService" class="service.impl.UserServiceimpl">

//</bean>
@Service("wee")
public class UserServiceimpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    @Autowired // 按照数据类型从Spring容器中进行匹配
    @Qualifier("userDao") // 是按照id从容器匹配
//    @Resource(name = "userDao") //相当于 @Autowired + @Qualifier
    private UserDao userDao;
    @Value("${jdbc.driver}")
    private String driver;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }
}
