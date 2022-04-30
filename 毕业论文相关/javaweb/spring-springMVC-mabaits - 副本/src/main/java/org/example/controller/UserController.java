package org.example.controller;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController//controller是对请求的资源进行分层处理和响应（也将该类注册到容器）。responseBody
@RequestMapping("/user") //requestMapping是对请求的资源路径进行映射，支持所有请求
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    /**
     * 返回值为object结合@responseBody使用，表示将对象序列化后的数据放在响应体返回 默认为json字符串格式
     * 返回值为string结合@responseBody使用，表示返回text/plain 纯文本
     * 返回值为string不结合注释使用，表示的是返回URI资源路径的字符串（重定向或转发）
     * @RequestBody  只用于接收json数据格式
     */
    public Object login(@RequestBody User user, HttpServletRequest req){
        //通过前端传入的用户账号，在数据库查询用户信息，返回一个用户
        User exist = userService.query(user.getUsername());
        if(exist == null) throw new AppException("USR001", "用户不存在");
        //通过账号查到的用户对象，还需要验证密码
        if(!exist.getPassword().equals(user.getPassword()))
            throw new AppException("USR002", "用户名或密码错误");
        //用户名，密码验证通过，创建session并保存用户信息
        HttpSession session = req.getSession();
        //保存数据库查询出来的User，信息是全的
        session.setAttribute("user", exist);
        return null;
    }

    @PostMapping("/register")
    //注意请求数据绑定user对象中的属性，及headFile变量名，要一致
    public Object register(User user, MultipartFile headFile){

        userService.register(user, headFile);
        return null;
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("user");
        return null;
    }
}
