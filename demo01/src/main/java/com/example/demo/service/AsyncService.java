package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {
//    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("你遇到了一个错误");
        }
    }
}
