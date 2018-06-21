package weixin.commonAPIs;

import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.CommonJsonSendType;
import weixin.helpers.StringHelper;
import weixin.utilities.httpUtility.Get;
import weixin.utilities.httpUtility.Post;

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
    public static WxJsonResult Send(String accessToken, String urlFormat, Object data, CommonJsonSendType sendType, int timeOut, boolean checkValidationResult) {
        return Send(accessToken, urlFormat, data, sendType, timeOut, checkValidationResult);
    }

    /**
     * @Author:Jrss
     * @Desp:向需要AccessToken的API发送消息的公共方法
     */
    public static <T> T Send(String accessToken, String urlFormat, Object data, CommonJsonSendType sendType, int timeOut, bool checkValidationResult)

    {
        try {
            String url = "";
            if (accessToken == null || accessToken.equalsIgnoreCase("")) {
                url = urlFormat;
            } else {
                url = String.format(urlFormat, StringHelper.getUrlData(accessToken));
            }

            switch (sendType) {
                case CommonJsonSendType.GET:
                    return Get.GetJson < T > (url);
                case CommonJsonSendType.POST:
                    SerializerHelper serializerHelper = new SerializerHelper();
                    var jsonString = serializerHelper.GetJsonString(data, jsonSetting);
                    using(MemoryStream ms = new MemoryStream())
                {
                    var bytes = Encoding.UTF8.GetBytes(jsonString);
                    ms.Write(bytes, 0, bytes.Length);
                    ms.Seek(0, SeekOrigin.Begin);

                    WeixinTrace.SendApiPostDataLog(url, jsonString);//记录Post的Json数据

                    //PostGetJson方法中将使用WeixinTrace记录结果
                    return Post.PostGetJson < T > (url,null, ms, timeOut:timeOut, checkValidationResult:
                    checkValidationResult);
                }
                default:
                    throw new ArgumentOutOfRangeException("sendType");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
