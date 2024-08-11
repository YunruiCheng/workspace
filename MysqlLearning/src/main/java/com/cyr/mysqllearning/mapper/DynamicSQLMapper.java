package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicSQLMapper {

    /**
     * 条件查询：
     *  1.对于如果需要用到Emp内嵌套类Dept的字段查询，也是直接按【对象.字段】级联查询即可
     *          <if test="dept != null">
     *             <if test="dept.did != null and dept.did != ''">
     *                 and did = #{dept.did}
     *             </if>
     *         </if>
     * @param emp
     * @return
     */
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
