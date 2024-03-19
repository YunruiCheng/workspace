package com.example.remotedebug.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

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

}