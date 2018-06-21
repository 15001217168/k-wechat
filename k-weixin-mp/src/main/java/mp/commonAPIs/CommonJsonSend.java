package mp.commonAPIs;

import weixin.commonAPIs.BaseCommonJsonSend;
import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.CommonJsonSendType;

/**
 * @Author:Jrss
 * @Desp:通用 JSON 数据获取
 * @Date:Create in 18:53 2018/6/20
 * @Modified By:
 */
public class CommonJsonSend {
    /**
     * @Author:Jrss
     * @Desp:向需要AccessToken的API发送消息的公共方法
     */
    public static WxJsonResult send(String accessToken, String urlFormat, Object data, CommonJsonSendType sendType, int timeOut, boolean checkValidationResult) {
        WxJsonResult result = null;
        try {
            result = BaseCommonJsonSend.send(accessToken, urlFormat, data, sendType, timeOut,
                    checkValidationResult);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    /**
     * @Author:Jrss
     * @Desp:向需要AccessToken的API发送消息的公共方法
     */
    public static <T> T doSend(
            String accessToken, String
            urlFormat,
            Object data, CommonJsonSendType
                    sendType,
            int timeOut, boolean checkValidationResult)

    {
        return BaseCommonJsonSend.doSend(accessToken,
                urlFormat, data, sendType, timeOut, checkValidationResult);
    }
}
