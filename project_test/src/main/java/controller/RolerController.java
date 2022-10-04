package controller;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;
import service.impl.RoleServiceImpl;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RolerController {
    @Autowired
    private RoleService roleService;
//    public void setRoleService(RoleService roleService) {
//        this.roleService = roleService;
//    }
    @RequestMapping("/list")
    public ModelAndView RollerList() {
        ModelAndView modelAndView = new ModelAndView();
        RoleService roleService = new RoleServiceImpl();
        List<Role> list = roleService.getRoleList();
        // 模型
        modelAndView.addObject("rolerList", list);
        // 视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    // 获取角色列表
    @CrossOrigin
    @RequestMapping("/listData")
    @ResponseBody
    public List<Role> RollerList_data() {
        List<Role> list = roleService.getRoleList();
        System.out.println("进来了");
        System.out.println(list);
        return list;
    }
    // 添加角色
    @CrossOrigin
    @RequestMapping("/addRole")
    @ResponseBody
    public int addRole(@RequestBody Role role) {
        int num = roleService.addRole(role);
        System.out.println(role);
        return num;
    }
}
