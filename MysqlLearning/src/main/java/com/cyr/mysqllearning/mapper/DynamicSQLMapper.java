package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicSQLMapper {

    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 批量删除
     * @param eids
     * @return
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 批量添加
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
