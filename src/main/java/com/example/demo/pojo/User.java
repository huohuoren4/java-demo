package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class User {
    private Integer id;
    private String username;
    private String password;
    private String realname;

}
