package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    User getUserByID(int id);
    User getUserByMap(Map<String, Object> map);
    List<User> getUser();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
}
