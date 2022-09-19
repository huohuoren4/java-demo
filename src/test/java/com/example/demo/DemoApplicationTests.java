package com.example.demo;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	DataSource dataSource;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Test
	void contextLoads() throws SQLException {
		// 测试mysql 数据库的连通性
		System.out.println("#######################################");
		Connection connection = dataSource.getConnection();
		if ( connection != null ) {
			System.out.println("数据库连接成功 !!!!");
		}else{
			System.out.println("数据库连接失败 !!!!");
		}

		ValueOperations<String, String> con = stringRedisTemplate.opsForValue();
		con.set("name", "123");
		System.out.println(con.get("name"));


	}

}
