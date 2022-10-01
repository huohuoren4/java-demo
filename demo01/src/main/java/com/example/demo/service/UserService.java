package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByID(int id){
        return userMapper.getUserByID(id);
    }
    public List<User> getUser(){
        return userMapper.getUser();
    }
    public User getUserByMap(Map<String, Object> map){
        return userMapper.getUserByMap(map);
    }
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    public int deleteUser(User user){
        return userMapper.deleteUser(user);
    }
}
