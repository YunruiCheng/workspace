package common;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 重构提取连接、关闭es代码部分
 * 接下来，如果想让Elasticsearch完成一些操作，就编写一个lambda式即可。
 * ConnectElasticsearch.connect(client -> {
 * 			//do something
 *         });
 */
public class ConnectElasticsearch {
    public static void connect(ElasticsearchTask task){
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        try {
            task.doSomething(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
