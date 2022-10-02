package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping( "/getUserByID/{id}")
    @ApiOperation("通过ID查询用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id")
    })
    public Object getUserByID(@PathVariable int id) {
        User data= userService.getUserByID(id);
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @GetMapping("/getUser")
    @ApiOperation("查询所有用户")
    public Object getUser() {
        List<User> data = userService.getUser();
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @GetMapping("/getUserByMap")
    @ApiOperation("通过名字查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id"),
            @ApiImplicitParam(name = "username", value = "用户名"),
    })
    public Object getUserByMap(@RequestParam(required = false) int id, @RequestParam(required = false) String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        User data = userService.getUserByMap(map);
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @PostMapping("/insertUser")
    @ApiOperation("插入用户数据")
    @ApiParam(name = "user", value = "用户数据")
    public String insertUser(@RequestBody User user, @RequestHeader String token) {
        int flag = userService.insertUser(user);
        if (flag != 0) {
            return "数据添加成功 !";
        }
        return "数据添加失败 !";
    }

    /**
     * 更新用户信息
     * @param: request
     * @return
     */
    @PostMapping("/updateUser")
    @ApiOperation("更新用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id"),
        @ApiImplicitParam(name = "username", value = "用户名"),
    })
    public String updateUser(@RequestParam int id ,@RequestParam String username ) {
        User user = new User(id, username, null, null);
        int flag = userService.updateUser(user);
        if (flag != 0) {
            return "数据更新成功 !";
        }
        return "数据更新失败 !";
    }

    @PostMapping("/deleteUser")
    @ApiOperation("输出用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id"),
    })
    public String deleteUser(@RequestParam int id) {
        User user = new User(id, null, null, null);
        int flag = userService.deleteUser(user);
        if (flag != 0) {
            return "删除数据成功 !";
        }
        return "删除数据失败 !";
    }
}
