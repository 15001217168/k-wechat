package weixin.commonAPIs;

import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.CommonJsonSendType;
import weixin.helpers.StringHelper;
import weixin.utilities.httpUtility.Get;
import weixin.utilities.httpUtility.Post;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Jrss
 * @Desp:通过CommonJsonSend中的方法调用接口
 * @Date:Create in 10:50 2018/6/21
 * @Modified By:
 */
public class BaseCommonJsonSend {
    /**
     * @Author:Jrss
     * @Desp:向需要AccessToken的API发送消息的公共方法
     */
    public static WxJsonResult send(String accessToken, String urlFormat, Object data, CommonJsonSendType sendType, int timeOut, boolean checkValidationResult) {
        return (WxJsonResult) doSend(accessToken, urlFormat, data, sendType, timeOut, checkValidationResult,WxJsonResult.class);
    }

    /**
     * @Author:Jrss
     * @Desp:向需要AccessToken的API发送消息的公共方法
     */
    public static <T> T doSend(String accessToken, String urlFormat, Object data, CommonJsonSendType sendType, int timeOut, boolean checkValidationResult, Class<T> type)

    {
        try {
            String url = "";
            if (accessToken == null || accessToken.equalsIgnoreCase("")) {
                url = urlFormat;
            } else {
                url = String.format(urlFormat, StringHelper.getUrlData(accessToken));
            }

            switch (sendType) {
                case GET:
                    return Get.getJson(url, type);
                case POST:
                    Map<String, Object> post = new HashMap<String, Object>();
                    return Post.postGetJson(url, post, null, null, type);
                default:
                    return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
