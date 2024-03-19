package QueryOps;

import common.ConnectElasticsearch;
import common.ElasticsearchTask;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class QueryDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(new ElasticsearchTask() {
            public void doSomething(RestHighLevelClient client) throws Exception {

                // step 1.创建搜索请求对象
                SearchRequest request = new SearchRequest().indices("user");
                // step 2.创建查询请求体构建器
                SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


                // 1.查询所有索引数据
//                sourceBuilder.query(QueryBuilders.matchAllQuery());


                // 2.条件查询
//                sourceBuilder.query(QueryBuilders.termQuery("age", "30"));


                // 3.分页查询
//                sourceBuilder.query(QueryBuilders.matchAllQuery());
//                // 分页查询
//                // 当前页其实索引(第一条数据的顺序号)， from
//                sourceBuilder.from(0);
//                // 每页显示多少条 size
//                sourceBuilder.size(2);

                // 4.查询排序
//                sourceBuilder.query(QueryBuilders.matchAllQuery());
//                // 排序
//                sourceBuilder.sort("age", SortOrder.ASC);


                // 4.组合查询
//                BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//                // 必须包含
//                boolQueryBuilder.must(QueryBuilders.matchQuery("age", "30"));
//                // 一定不含
//                boolQueryBuilder.mustNot(QueryBuilders.matchQuery("name", "zhangsan"));
//                // 可能包含
//                boolQueryBuilder.should(QueryBuilders.matchQuery("sex", "男"));
//                sourceBuilder.query(boolQueryBuilder);

                // 5.范围查询
                // 构建查询的请求体
//                RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//                // 大于等于
//                rangeQuery.gte("30");
                // 小于等于
//                rangeQuery.lte("40");
//                sourceBuilder.query(rangeQuery);

                // 6.模糊查询
                // 构建查询的请求体
//                sourceBuilder.query(QueryBuilders.fuzzyQuery("name","wangwu").fuzziness(Fuzziness.ONE));

                // 7.高亮查询
                //构建查询方式：高亮查询
//                TermsQueryBuilder termsQueryBuilder =
//                        QueryBuilders.termsQuery("name","zhangsan");
//                //设置查询方式
//                sourceBuilder.query(termsQueryBuilder);
//                //构建高亮字段
//                HighlightBuilder highlightBuilder = new HighlightBuilder();
//                highlightBuilder.preTags("<font color='red'>");//设置标签前缀
//                highlightBuilder.postTags("</font>");//设置标签后缀
//                highlightBuilder.field("name");//设置高亮字段
//                //设置高亮构建对象
//                sourceBuilder.highlighter(highlightBuilder);
//                //设置请求体


                // 8.最大值查询
//                sourceBuilder.aggregation(AggregationBuilders.max("maxAge").field("age"));
                //设置请求体


                // 9.分组查询
                sourceBuilder.aggregation(AggregationBuilders.terms("age_groupby").field("age"));
                //设置请求体


                // step 3.客户端发送请求，获取响应对象
                request.source(sourceBuilder);
                SearchResponse response = client.search(request, RequestOptions.DEFAULT);
                // step 4.输出结果
                SearchHits hits = response.getHits();
                System.out.println("took:" + response.getTook());
                System.out.println("timeout:" + response.isTimedOut());
                System.out.println("total:" + hits.getTotalHits());
                System.out.println("MaxScore:" + hits.getMaxScore());
                System.out.println("hits========>>");
                for (SearchHit hit : hits) {
                    //输出每条查询的结果信息
                    System.out.println(hit.getSourceAsString());
                }
                System.out.println("<<========");
            }
        });
    }

}
