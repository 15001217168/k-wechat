package weixin.utilities.httpUtility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import weixin.GlobalConf;
import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.ReturnCode;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * @Author:Jrss
 * @Desp:Get 请求处理
 * @Date:Create in 11:06 2018/6/21
 * @Modified By:
 */
public class Get {
    /**
     * @Author:Jrss
     * @Desp:获取随机文件名
     */
    private static String getRandomFileName() {
        return Calendar.getInstance().getTimeInMillis() + UUID.randomUUID().toString().substring(0, 6);
    }

    /**
     * @Author:Jrss
     * @Desp:ET方式请求URL，并返回T类型
     */
    public static <T> T getJson(String url, Class<T> type) {
        String resultText = RequestUtility.httpGet(url);
        T result = null;
        ObjectMapper mapper = new ObjectMapper();
//        当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
//        因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            result = mapper.readValue(resultText, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
