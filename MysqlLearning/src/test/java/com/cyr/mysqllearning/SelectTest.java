package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.SelectMapper;
import com.cyr.mysqllearning.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 这两个注解必须要，不然SelectMapper注入不了为NULL
 * @RunWith(SpringRunner.class)
 * @SpringBootTest(classes = MysqlLearningApplication.class)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlLearningApplication.class)
public class SelectTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    private SelectMapper mapper;

    /**
     * 测试连接：Springboot 通过读取yml的dataSource配置信息连接Mysql
     */
    @Test
    public void contextLoads() throws SQLException {
        //是否获取到数据源
        System.out.println(dataSource.getClass());
        //获取一个连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testGetUserById() throws IOException {
        User userById = mapper.getUserById(10);
        System.out.println(userById);
//      结果：User{id=10, username='ton', password='123', age=23, sex='G', email='123@321.com'}
    }
    @Test
    public void testGetUserToMap() throws IOException {
        Map<String, Object> userToMap = mapper.getUserToMap(10);
        System.out.println(userToMap);
//        结果：{password=123, sex=G, id=10, age=23, email=123@321.com, username=ton}
    }

    @Test
    public void testGetUserList() throws IOException {
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
//        结果为：[User{id=3, username='admin', password='123456', age=23, sex='M', email='123456@qq.com'},
//        User{id=4, username='admin', password='123456', age=23, sex='M', email='123456@qq.com'},
//        User{id=6, username='zhangsan', password='123456', age=23, sex='M', email='123456@qq.com'}]
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
//        结果：[{password=123456, sex=M, id=3, age=23, email=123456@qq.com, username=admin},
//        {password=123456, sex=M, id=4, age=23, email=123456@qq.com, username=admin},
//        {password=123456, sex=M, id=6, age=23, email=123456@qq.com, username=zhangsan},
    }

}
