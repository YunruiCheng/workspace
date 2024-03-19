package com.cyr.mysqllearning;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan(value = "com.cyr.mysqllearning.mapper", annotationClass = Mapper.class)
public class MysqlLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlLearningApplication.class, args);
    }

}
