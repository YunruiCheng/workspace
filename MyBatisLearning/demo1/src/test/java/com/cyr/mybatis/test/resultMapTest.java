package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.SelectMapper;
import com.cyr.mybatis.mapper.resultMapMapper;
import com.cyr.mybatis.pojo.Dept;
import com.cyr.mybatis.pojo.Emp;
import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class resultMapTest {
    private static resultMapMapper getMapMapper() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        resultMapMapper mapper = sqlSession.getMapper(resultMapMapper.class);
        return mapper;
    }

    @Test
    public void testGetAllEmp() throws IOException {
        resultMapMapper mapper = getMapMapper();
        //唯一改变
        List<Emp> allEmp = mapper.getAllEmp();
        for(Emp e:allEmp){
            System.out.println(e);
        }
    }
    @Test
    public void testGetEmpAndDept() throws IOException {
        //读取MyBatis的核心配置文件
        resultMapMapper mapper = getMapMapper();
        //唯一改变
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
        // 结果：Emp{eid=1, empName='zhangsan', age=21, sex='M', email='123456@qq.com', dept=Dept{did=1, deptName='eFunds', emps=null}}
    }

    @Test
    public void testGetDeptAndEmp() throws IOException {
        //读取MyBatis的核心配置文件
        resultMapMapper mapper = getMapMapper();
        //唯一改变
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
        // 结果：Dept{did=1, deptName='eFunds', emps=[Emp{eid=1, empName='zhangsan', age=21, sex='M', email='123456@qq.com', dept=null},
        // Emp{eid=3, empName='libai', age=24, sex='M', email='acbdefg@gmail.com', dept=null}]}
    }



}
