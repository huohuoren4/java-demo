package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermgr")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping( "/users/{user_id}")
    @ApiOperation("查询用户详情")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user_id", value = "用户id"),
        @ApiImplicitParam(name = "token", value = "用户身份凭证")
    })
    public Object getUserByID(@PathVariable int user_id , @RequestHeader String token ) {
        User data= userService.getUserByID(user_id);
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @GetMapping("/users")
    @ApiOperation("查询用户列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "用户名"),
        @ApiImplicitParam(name = "token", value = "用户身份凭证")
    })
    public Object getUser(@RequestParam(required = false) String name, @RequestHeader String token ) {
        List<User> data = userService.getUser();
        if (data != null ) {
            return data;
        }
        return "查询数据为空 !";
    }

    @PostMapping("/users")
    @ApiOperation("创建用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user", value = "用户信息"),
        @ApiImplicitParam(name = "token", value = "用户身份凭证")
    })
    public String insertUser(@RequestBody User user, @RequestHeader String token ) {
        int flag = userService.insertUser(user);
        if (flag != 0) {
            return "数据添加成功 !";
        }
        return "数据添加失败 !";
    }

    @PutMapping("/users/{user_id}")
    @ApiOperation("更新用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user_id", value = "用户id"),
        @ApiImplicitParam(name = "user", value = "用户信息"),
        @ApiImplicitParam(name = "token", value = "用户身份凭证")
    })
    public String updateUser(@RequestParam int user_id ,@RequestBody User user ,@RequestHeader String token ) {
        user.setId(user_id);
        int flag = userService.updateUser(user);
        if (flag != 0) {
            return "数据更新成功 !";
        }
        return "数据更新失败 !";
    }

    @DeleteMapping("/users/{user_id}")
    @ApiOperation("删除用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user_id", value = "用户id"),
        @ApiImplicitParam(name = "token", value = "用户身份凭证")
    })
    public String deleteUser(@PathVariable int user_id, @RequestHeader String token ) {
        User user = new User(user_id, null, null, null);
        int flag = userService.deleteUser(user);
        if (flag != 0) {
            return "删除数据成功 !";
        }
        return "删除数据失败 !";
    }
}



