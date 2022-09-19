package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页控制器
 */
@Controller
public class HelloController {
    /**
     * 首页的路由"/"
     * @param model: thymeleaf 模板引擎传值
     * @param request: HTTP请求
     * @return
     */
    @GetMapping(value = "/", headers = {})
    @ResponseBody
    public Map<String, Object> index(Model model, HttpServletRequest request ) {
        Map<String, Object> map = new HashMap<>();
        map.put("水果", Arrays.asList("123", "456"));
        map.put("蔬菜", "卷心菜");
        return map ;
    }

    /**
     * 用户表单
     * @param request: HTTP请求
     * @return
     */
    @PostMapping("/modifyUsername")
    public Map<String, Object> form(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        map.put("name", request.getParameter("name"));
        map.put("password", request.getParameter("password"));
        map.put("address", request.getParameter("address"));
        return map;
    }
}
