package org.example.MongoLearning;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.example.MongoLearning.po.Student;
import org.example.MongoLearning.repository.StudentMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDemoApplication.class)
public class MongoDemoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private StudentMongoRepository studentMongoRepository;

    /**
     * 保存文档到Mongdb
     */
    @Test
    public void saveTest() {
        List<Student> list = new ArrayList<>(50);
        for (int i = 0; i < 100; i++){
            Student student = new Student(i+"", i%2==0?"zs":"ls", i, i%3==0?1:0);
            list.add(student);
        }
        //mongoTemplate.insert(student);
        //mongoTemplate.save()

        //如果ID存在就会变成修改
        studentMongoRepository.saveAll(list);

        //不允许ID重复
        //repository.insert(students);
    }

    /**
     * 修改文档 ， 可以使用repository.save或mongoTemplate.save方法修改，也可以使用mongoTemplate.updateFirst
     */
    @Test
    public void updateTest() {
        //条件
        Query query = Query.query(Criteria.where("name").is("zs"));
        //修改的内容
        Update update = new Update().set("age", 18);
        //执行修改
        UpdateResult result = mongoTemplate.updateFirst(query, update, "students");
        //UpdateResult result = mongoTemplate.updateMulti(query, update, "students");
        System.out.println(result);
    }

    /**
     * 实例：根据ID删除 ,或根据条件删除
     *
     * Query.query : 构建删除查询对象
     * Criteria.where ： 构建具体条件
     */
    @Test
    public void deleteTest() {
        //repository.deleteById("2");

        //根据条件删除，把name=zs的从students这个集合中删除掉
        Query query = Query.query(Criteria.where("name").is("zs"));
        DeleteResult result = mongoTemplate.remove(query, "students");
        System.out.println(result);
    }

    /**
     * 实例：根据ID查找 ,或查找所有
     */
    @Test
    public void findTest() {
//        Student findResult = studentMongoRepository.findById("2").get();
//        System.out.println(findResult);

        //查找所有
        studentMongoRepository.findAll().forEach(student -> System.out.println(student));
    }


}
