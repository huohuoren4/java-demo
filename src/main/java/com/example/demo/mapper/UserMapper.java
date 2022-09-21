package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface UserMapper {
    User getUser(User user);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
}
