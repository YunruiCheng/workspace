package com.cyr.mysqllearning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class MysqlLearningApplicationTests {

    //数据源
    @Autowired
    DataSource dataSource;

    /**
     * 方式一：Springboot 通过读取yml的dataSource配置信息连接Mysql
     * Output:class org.springframework.jdbc.datasource.DriverManagerDataSource
     *        com.mysql.cj.jdbc.ConnectionImpl@43d3aba5
     * @throws SQLException
     */
    @Test
    void contextLoads() throws SQLException {
        //是否获取到数据源
        System.out.println(dataSource.getClass());
        //获取一个连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
