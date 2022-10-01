package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserByID/{id}")
    public Object getUserByID(@PathVariable int id) {
        User data= userService.getUserByID(id);
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @GetMapping("/getUser")
    public Object getUser() {
        List<User> data = userService.getUser();
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @GetMapping("/getUserByMap")
    public Object getUserByMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));
        map.put("username", request.getParameter("username"));
        User data = userService.getUserByMap(map);
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

    /**
     * 更新用户信息
     * @param request
     * @return
     */
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
