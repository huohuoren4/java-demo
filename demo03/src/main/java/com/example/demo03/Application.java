package com.example.demo03;

import com.example.demo03.test.Animal;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
//        int num = Integer.parseInt(args[1]);
        int num = 10000;
        for (int i = 1; i <= num; i++) {
            list.add(new Animal("wewe", "red"));
        }
        System.out.println(list.size());
        System.out.println("\033[32mSuccess:字符串 (^_^)\033[0m");
    }
}
