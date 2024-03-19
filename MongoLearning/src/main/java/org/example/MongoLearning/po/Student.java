package org.example.MongoLearning.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "students")	//集合名字
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id    //对应id , 字段名对应了mongo中的——id
    private String _id;

    //标记字段在mongo中的名字和类型
    @Field(name = "name",targetType = FieldType.STRING)
    private String name;

    @Field(name = "age" , targetType = FieldType.INT32)
    private Integer age;

    @Field(name = "sex" , targetType = FieldType.INT32)
    private Integer sex;

}

