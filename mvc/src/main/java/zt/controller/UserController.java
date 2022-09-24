package zt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import zt.demo.School;
import zt.demo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // 请求地址 lockhost:8080/user/quick
    @RequestMapping("/quick")
    public String save() {
        System.out.println("controller......");
        return "success" ;
    }
    @RequestMapping("/quick1")
    public ModelAndView save1() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称
        modelAndView.addObject("username", "123");
        modelAndView.setViewName("upload");
        return modelAndView;
    }
    @RequestMapping("/quick2")
    public ModelAndView save2(ModelAndView modelAndView) {
        // 设置视图名称
        modelAndView.addObject("username", "123");
        modelAndView.setViewName("upload");
        return modelAndView;
    }
    @RequestMapping("/quick3")
    public String save3(Model model) {
        // 设置视图名称
        model.addAttribute("username", "123");
        return "upload";
    }
    @RequestMapping("/quick4")
    public String save4(HttpServletRequest request) {
        // 设置视图名称
        request.setAttribute("username", "123");
        return "upload";
    }
    @RequestMapping("/quick5")
    public void save5(HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("quick5");
        httpServletResponse.getWriter().print("张涛");
    }
    @RequestMapping("/quick6")
    // 回写数据，而非回写页面
    @ResponseBody
    public String save6() {
        System.out.println("我要回写数据了");
        return "我是zahngtao";
    }

    @RequestMapping("/quick7")
    // 回写数据，而非回写页面
    @ResponseBody
    public String save7() {
        System.out.println("我要返回json");
        return "{\"username\": \"zhangt\"}";
    }

    @RequestMapping("/quick8")
    // 回写数据，而非回写页面
    @ResponseBody
    public String save8() throws JsonProcessingException {
        System.out.println("我要返回json对象");
        User user = new User();
        user.setUserName("zahngtao");
        user.setAge(26);
        ObjectMapper objectMapper = new ObjectMapper();
        // 对象转json
        String userInfo =  objectMapper.writeValueAsString(user);
        return userInfo;
    }



    @RequestMapping("/quick9")
    // 回写数据，而非回写页面
    @ResponseBody
    public User save9() throws JsonProcessingException {
        System.out.println("我要返回json对象");
        User user = new User();
        user.setUserName("zahngtao");
        user.setAge(26);
        // ObjectMapper objectMapper = new ObjectMapper();
        // 对象转json，后期直接在spring中进行配置
        // String userInfo =  objectMapper.writeValueAsString(user);
        return user;
    }



    @RequestMapping("/quick10")
    // 回写数据，而非回写页面
    @ResponseBody
    public User save10(User user) throws JsonProcessingException {
        return user;
    }

    @RequestMapping("/quick11")
    // 回写数据，而非回写页面
    @ResponseBody
    public void save11(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick12")
    // 回写数据，而非回写页面
    @ResponseBody
    public List save12(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
        return userList;
    }



    @RequestMapping("/quick13")
    // 回写数据，而非回写页面
    @ResponseBody
    public School save12(@RequestBody School school) throws IOException {
        System.out.println(school);
        return school;
    }



    @RequestMapping("/quick14")
    // 回写数据，而非回写页面
    @ResponseBody
    public void save14(@RequestParam(value="name") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping("/quick15/{name}")
    // 回写数据，而非回写页面
    @ResponseBody
//    public void save15(@RequestParam(value="name") String username) throws IOException {
//        System.out.println(username);
//    }
    public void save15(String name) throws IOException {
        System.out.println(name);
    }
    @RequestMapping("/quick16")
    // 回写数据，而非回写页面
    @ResponseBody
    public void save16(String username, @RequestHeader(value = "User-Agent") String date) throws IOException {
        System.out.println(date);
        System.out.println(username);
    }

    @RequestMapping("/quick17")
    // 回写数据，而非回写页面
    @ResponseBody
    public void save17(MultipartFile uploadFile) throws IOException {
        String fileName = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\app\\"+fileName));
    }

    @RequestMapping("/quick18")
    // 回写数据，而非回写页面
    @ResponseBody
    public void save18(MultipartFile[] uploadFile) throws IOException {
        for(MultipartFile file : uploadFile) {
            String fileName = file.getOriginalFilename();
            file.transferTo(new File("D:\\app\\"+fileName));
        }
    }
}
