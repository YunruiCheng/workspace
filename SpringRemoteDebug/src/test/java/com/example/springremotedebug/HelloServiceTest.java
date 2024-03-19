package com.example.springremotedebug;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.springremotedebug.Service.helloService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private helloService helloService;
    @Test
    public void testHello(){
        String libai = helloService.hello("libai", 1);
        String zhaojun = helloService.hello("zhaojun", 2);
        System.out.println(libai);
        System.out.println(zhaojun);
    }
}
