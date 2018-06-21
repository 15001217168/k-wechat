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
    public static <T> T getJson(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String resultText = "";
        T result = null;
        try {
            // 通过址默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头信息，鉴权
            // httpGet.setHeader("", "");
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(GlobalConf.TimeOut)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(GlobalConf.TimeOut)// 请求超时时间
                    .setSocketTimeout(GlobalConf.TimeOut)// 数据读取超时时间
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            // 通过EntityUtils中的toString方法将结果转换为字符串
            resultText = EntityUtils.toString(entity);
            //可能发生错误
            ObjectMapper mapper = new ObjectMapper();
//        当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
//        因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            result = mapper.readValue(resultText, new TypeReference<T>() {
            });

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
