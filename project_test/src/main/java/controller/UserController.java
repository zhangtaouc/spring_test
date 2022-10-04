package controller;

import dao.RoleDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    private RoleDao roleDao;


    @RequestMapping("/userList")
    @ResponseBody
    @CrossOrigin
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    // 添加用户
    @RequestMapping("/addUser")
    @ResponseBody
    @CrossOrigin
    public int addUser(@RequestBody Object obj) {
        Map info = (Map) obj;
        User user = new User();
        user.setUsername(info.get("username").toString());
        user.setEmail(info.get("email").toString());
        user.setPassword(info.get("password").toString());
        user.setPhoneNum(info.get("phoneNum").toString());
        Object str = (Object) info.get("roleList");
        System.out.println(str);
        int num = userService.addUser(user, str);
        return num;
    }

    // 登录
    @RequestMapping("/login")
    @ResponseBody
    @CrossOrigin
    public User login(@RequestBody User user, HttpSession session) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        User user_ = userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println("进来了");
        System.out.println(user_);
        session.setAttribute("user", user_);
        return user_;
    }
}
