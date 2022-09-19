package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable int id) {
        User user = new User(id, "", "", "");
        User data= userService.getUser(user);
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @PostMapping("/insertUser")
    public String insertUser(HttpServletRequest request) {
        User user = new User(null, request.getParameter("username"), request.getParameter("password"), request.getParameter("realname"));
        int flag = userService.insertUser(user);
        if (flag != 0) {
            return "数据添加成功 !";
        }
        return "数据添加失败 !";
    }

    @PostMapping("/updateUser")
    public String updateUser(HttpServletRequest request) {
        User user = new User(Integer.parseInt(request.getParameter("id")), request.getParameter("username"), null, null);
        int flag = userService.updateUser(user);
        if (flag != 0) {
            return "数据更新成功 !";
        }
        return "数据更新失败 !";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request) {
        User user = new User(Integer.parseInt(request.getParameter("id")), null, null, null);
        int flag = userService.deleteUser(user);
        if (flag != 0) {
            return "删除数据成功 !";
        }
        return "删除数据失败 !";
    }
}
