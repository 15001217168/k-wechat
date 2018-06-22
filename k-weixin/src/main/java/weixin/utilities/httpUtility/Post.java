package weixin.utilities.httpUtility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import weixin.GlobalConf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 11:06 2018/6/21
 * @Modified By:
 */
public class Post {
    /**
     * @Author:Jrss
     * @Desp:发起Post请求
     */
    public static <T> T postGetJson(String url, Map<String, Object> paramMap, String data, SSLConnectionSocketFactory ssl, Class<T> type) {

        String resultText = RequestUtility.httpPost(url, data, paramMap, ssl, 0);
        T result = null;

        ObjectMapper mapper = new ObjectMapper();
//        当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
//        因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            result = (T) mapper.readValue(resultText, type);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
