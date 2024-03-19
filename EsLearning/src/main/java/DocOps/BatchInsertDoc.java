package DocOps;

import common.ConnectElasticsearch;
import common.ElasticsearchTask;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class BatchInsertDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(new ElasticsearchTask() {
            public void doSomething(RestHighLevelClient client) throws Exception {
                //创建批量新增请求对象
                BulkRequest request = new BulkRequest();
                request.add(new
                        IndexRequest().index("user").id("1001").source(XContentType.JSON, "name",
                        "zhangsan"));
                request.add(new
                        IndexRequest().index("user").id("1002").source(XContentType.JSON, "name",
                        "lisi"));
                request.add(new
                        IndexRequest().index("user").id("1003").source(XContentType.JSON, "name",
                        "wangwu"));
                //客户端发送请求，获取响应对象
                BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
                //打印结果信息
                System.out.println("took:" + responses.getTook());
                System.out.println("items:" + responses.getItems());
            }
        });
    }
}