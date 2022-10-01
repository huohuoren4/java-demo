package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.LocaleResolver;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	DataSource dataSource;
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	LocaleResolver localeResolver;

	@Test
	void dbTest() throws SQLException {
		System.out.println(localeResolver.getClass());

		// 测试mysql 数据库的连通性
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
