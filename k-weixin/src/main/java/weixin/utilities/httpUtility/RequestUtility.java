package weixin.utilities.httpUtility;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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
 * @Date:Create in 19:04 2018/6/21
 * @Modified By:
 */
public class RequestUtility {

    /**
     * @Author:Jrss
     * @Desp:使用Post方法获取字符串结果，常规提交
     */
    public static String httpPost(String url, String data, Map<String, Object> formData, SSLConnectionSocketFactory ssl, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        return doHttpPost(url, data, formData, ssl, timeOut);
    }

    /**
     * @Author:Jrss
     * @Desp:使用Post方法获取字符串结果
     */
    public static String doHttpPost(String url, String data, Map<String, Object> formData, SSLConnectionSocketFactory ssl, int timeOut) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String resultText = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        if (ssl != null) {
            HttpClients.custom().setSSLSocketFactory(ssl).build();
        }
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(GlobalConf.TimeOut)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(GlobalConf.TimeOut)// 设置连接请求超时时间
                .setSocketTimeout(GlobalConf.TimeOut)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (null != formData && formData.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            // 通过map集成entrySet方法获取entity
            Set<Map.Entry<String, Object>> entrySet = formData.entrySet();
            // 循环遍历，获取迭代器
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> mapEntry = iterator.next();
                nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }
            // 为httpPost设置封装好的请求参数
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                if (data != null && !data.equalsIgnoreCase("")) {
                    httpPost.setEntity(new StringEntity(data));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            resultText = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
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
        return resultText;
    }


    /**
     * @Author:Jrss
     * @Desp:使用get方法获取字符串结果，常规提交
     */
    public static String httpGet(String url) {
        return doHttpGet(url);
    }

    /**
     * @Author:Jrss
     * @Desp:使用get方法获取字符串结果
     */
    public static String doHttpGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String resultText = "";
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
        return resultText;
    }

}
