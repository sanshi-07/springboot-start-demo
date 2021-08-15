package com.example.springbootthirdapp;


import com.example.springbootstartjar.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UseController {

    //命名不规范，注意
    @Autowired
    private Service service;


    /**
     *这里已经不是0代码了，但是这里主要展示start的使用
     * 真正业务场景是我们可以在start的jar包中 实现spring的一些拦截器或者过滤器 让第三方应用自动加载这些bean
     *  完成0代码
     */
    @RequestMapping(value = "print")
    public void print(){
        service.print();
    }
}