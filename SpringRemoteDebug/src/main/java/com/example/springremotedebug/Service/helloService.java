package com.example.springremotedebug.Service;

import org.springframework.stereotype.Service;

@Service
public class helloService {
    public String hello(String name,int mode){
        if(mode==1){
            return "Hello " + name;
        } else {
            return "Bye " + name;
        }
    }
}
