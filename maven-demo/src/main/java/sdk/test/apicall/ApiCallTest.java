package sdk.test.apicall;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.unionpaysmart.data.sdk.api.DataApi;
import com.unionpaysmart.data.sdk.model.bill.request.BillsCardRequest;
import com.unionpaysmart.data.sdk.model.bill.response.BillsCardResponse;
import com.unionpaysmart.data.sdk.model.report.request.QueryNameRequest;
import com.unionpaysmart.data.sdk.model.report.response.QueryNameResponse;
import com.unionpaysmart.data.sdk.util.JSONUtil;

/**
 *
 * @author Nie Xiongding
 * @since 2015年4月1日 下午5:21:38
 */
public class ApiCallTest {
    private static Logger logger = Logger.getLogger(ApiCallTest.class);

    /**
     * 初始化参数: 设置account和privateKey
     */
    public static void init() {
        DataApi.isTest = true; // isTest为true时调用测试环境，为false时调用生产环境
        DataApi.account = "YOUR_ACCOUNT"; // 设置account
        DataApi.privateKey = "YOUR_PRIVATEKEY"; // 设置privateKey
    }

    @Test
    public void testQueryName() {
        init();
        QueryNameRequest queryNameRequest = new QueryNameRequest();
        // 设置接口必填参数
        queryNameRequest.setMName("中国银联");
        // 调用接口
        QueryNameResponse response = DataApi.callQueryName(queryNameRequest);
        logger.info(JSONUtil.toJson(response));
    }

    @Test
    public void testBillsCard() {
        init();
        BillsCardRequest billsCardRequest = new BillsCardRequest();
        billsCardRequest.setBeginDate(new Date(0));
        String[] cards = { "5201520000009998", "5201520000009997" };
        System.out.println(cards);
        billsCardRequest.setCard(cards);
        billsCardRequest.setCid("321045198912121235");
        billsCardRequest.setEndDate(new Date());
        billsCardRequest.setMobile("13612456523");
        billsCardRequest.setName("sss");
        billsCardRequest.setType(1);
        BillsCardResponse billsCardResponse = DataApi.callBillsCard(billsCardRequest);
        logger.info(JSONUtil.toJson(billsCardResponse));
    }
}
