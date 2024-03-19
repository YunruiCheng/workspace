package com.example.springremotedebug.controller;

import com.example.springremotedebug.Service.helloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    helloService helloService;

    @GetMapping("/index")
    public String index(){
        return "Hello World!";
    }

    @PostMapping("/test")
    public String test(Integer id,String name){
        System.out.println("id="+id);
        System.out.println("name="+name);
        if(id>0){
            return "success "+name;
        }else{
            return "fail";
        }
    }

    @PostMapping("/hello")
    public String testHello(Integer id,String name){
        String hello = helloService.hello(name, id);
        return hello;
    }
}