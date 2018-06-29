package mp.commonAPIs;

import com.sun.deploy.services.PlatformType;
import mp.containers.AccessTokenContainer;
import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.ReturnCode;

/**
 * @Author:Jrss
 * @Desp:针对AccessToken无效或过期的自动处理类
 * @Date:Create in 10:35 2018/6/21
 * @Modified By:
 */
public class ApiHandlerWapper {

    /// <summary>
    /// 使用AccessToken进行操作时，如果遇到AccessToken错误的情况，重新获取AccessToken一次，并重试。
    /// 使用此方法之前必须使用AccessTokenContainer.Register(_appId, _appSecret);或JsApiTicketContainer.Register(_appId, _appSecret);方法对账号信息进行过注册，否则会出错。
    /// </summary>
    /// <typeparam name="T"></typeparam>
    /// <param name="fun"></param>
    /// <param name="accessTokenOrAppId">AccessToken或AppId。如果为null，则自动取已经注册的第一个appId/appSecret来信息获取AccessToken。</param>
    /// <param name="retryIfFaild">请保留默认值true，不用输入。</param>
    /// <returns></returns>
    public static <T extends WxJsonResult> T TryCommonApi(
            Func<String, T> fun, String
            accessTokenOrAppId,
            boolean retryIfFaild) {

        Func<string> accessTokenContainer_GetFirstOrDefaultAppIdFunc =
                () =>AccessTokenContainer.GetFirstOrDefaultAppId();

        Func<string, bool> accessTokenContainer_CheckRegisteredFunc =
                appId =>AccessTokenContainer.CheckRegistered(appId);

        Func<string, bool, IAccessTokenResult> accessTokenContainer_GetAccessTokenResultFunc =
        (appId, getNewToken) =>AccessTokenContainer.GetAccessTokenResult(appId, getNewToken);

        int invalidCredentialValue = (int) ReturnCode.获取access_token时AppSecret错误或者access_token无效;

        var result = ApiHandlerWapperBase.
                TryCommonApiBase(
                        PlatformType.MP,
                        accessTokenContainer_GetFirstOrDefaultAppIdFunc,
                        accessTokenContainer_CheckRegisteredFunc,
                        accessTokenContainer_GetAccessTokenResultFunc,
                        invalidCredentialValue,
                        fun, accessTokenOrAppId, retryIfFaild);
        return result;
    }
}
