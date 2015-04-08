package com.unionpaysmart.apicall;

import upsmart.data.sdk.api.DataApi;
import upsmart.data.sdk.model.report.request.QueryNameRequest;
import upsmart.data.sdk.model.report.response.QueryNameResponse;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author Nie Xiongding
 * @since 2015年4月1日 下午5:21:38
 */
public class ApiCallTest {

    public static void main(String[] args) {
        init();

        QueryNameRequest queryNameRequest = new QueryNameRequest();
        // 设置接口必填参数
        queryNameRequest.setMName("中国银联");
        // 调用接口
        QueryNameResponse response = callQueryName(queryNameRequest);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * 相似商户名称搜索 接口地址：/merchant/queryName
     * 
     * @param billCardStatRequest
     * @return BillCardStatResponse
     */
    public static QueryNameResponse callQueryName(QueryNameRequest queryNameRequest) {
        return DataApi.callQueryName(queryNameRequest);
    }

    /**
     * 测试环境
     * 初始化参数: 设置account和privateKey
     */
    public static void init() {
        DataApi.account = "account"; // 设置account
        DataApi.privateKey = "6ad2693d06f9f75ceb3d41309f9e903c"; // 设置privateKey
    }
}