package com.example.h2mock;
import com.example.h2mock.entity.User;
import com.example.h2mock.services.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * A way to test from H2.
 * <p>
 * Just a demo, and change profile to 'test' for H2, and 'product' for MySQL.
 * 不使用mock测试
 */
@Profile("default")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class JavaSpringbootUnit5ApplicationTests {

    /**
     * 不使用mock测试
     */
    @Autowired
    IUserService userService;

    @Test
    @DisplayName("Integration test")
    void contextLoads() {
        List<User> all = userService.findAll();
        for(User u:all){
            System.out.println(u);
        }
        assertFalse(userService.findAll().isEmpty());
        assertEquals("cyr", userService.findAll().get(0).getName());
    }

}