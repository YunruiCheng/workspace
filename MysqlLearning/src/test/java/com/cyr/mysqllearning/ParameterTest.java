package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.ParameterMapper;
import com.cyr.mysqllearning.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlLearningApplication.class)
public class ParameterTest {
    @Autowired
    private ParameterMapper mapper;
    @Test
    public void testGetUserList() throws IOException {
        User zhangsan = mapper.getUserByUsername("zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void testInsertUser() throws IOException {
        User user = new User(null,"Thrump","123456",12,"M","123@321.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        mapper.CheckLoginByParam("Thrump","123456");
    }
}
