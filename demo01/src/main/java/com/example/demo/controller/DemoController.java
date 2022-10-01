package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  thymeleaf 模板引擎的使用示例
 */
@Controller
public class DemoController {

    @PostMapping("/com/example/demo")
    @ResponseBody
    public String demo(HttpServletRequest request ) {
        return "这里是 /demo 路由";
    }
}
