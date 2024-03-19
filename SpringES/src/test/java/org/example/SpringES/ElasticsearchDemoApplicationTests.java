package org.example.SpringES;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.example.SpringES.config.ElasticSearchConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchDemoApplication.class)
public class ElasticsearchDemoApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 测试连接
     */
    @Test
    public void contextLoads() {

        System.out.println(client);
    }

    /**
     * 保存、更新一条数据到"user"索引
     * @throws IOException
     */
    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("user"); //"user"为映射名字
        indexRequest.id("1"); //数据id

        //测试数据user，最后将对象转为json再传给indexRequest
        User user = new User();
        user.setName("libai");
        user.setAge(25);
        user.setSex("男");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON); //要保存内容

        //执行操作
        IndexResponse response = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        // 3.打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());
    }

    /**
     * 查询数据
     * @throws IOException
     */
    @Test
    public void searchData() throws IOException {
        // step 1.创建搜索请求对象：查询"user"索引的所有数据
        SearchRequest request = new SearchRequest().indices("user");
        // step 2.创建查询请求体构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询所有索引数据
        sourceBuilder.query(QueryBuilders.matchAllQuery());

        // step 3.客户端发送请求，获取响应对象
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, ElasticSearchConfig.COMMON_OPTIONS);
        // step 4.输出结果
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            //输出每条查询的结果信息
            System.out.println(hit.getSourceAsString());
        }
    }


    @Data
    class User{
        String name;
        Integer age;
        String sex;
    }
}
