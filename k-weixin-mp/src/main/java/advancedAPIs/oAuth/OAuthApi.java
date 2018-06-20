package advancedAPIs.oAuth;

import emums.EnumsOAuthScope;
import helpers.StringHelper;

/**
 * @Author:Jrss
 * @Desp:OAuth
 * @Date:Create in 18:27 2018/6/20
 * @Modified By:
 */
public class OAuthApi {
    /**
     * @Author:Jrss
     * @Desp:获取验证地址
     */
    public static String GetAuthorizeUrl(String appId, String redirectUrl, String state, EnumsOAuthScope scope, String responseType, boolean addConnectRedirect) {

        String url =
                String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=%s&scope=%s&state=%s%s#wechat_redirect",
                        StringHelper.getUrlData(appId), StringHelper.getUrlData(redirectUrl), StringHelper.getUrlData(responseType), StringHelper.getUrlData(scope.toString()), StringHelper.getUrlData(state),
                        addConnectRedirect ? "&connect_redirect=1" : "");

        /* 这一步发送之后，客户会得到授权页面，无论同意或拒绝，都会返回redirectUrl页面。
         * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。这里的code用于换取access_token（和通用接口的access_token不通用）
         * 若用户禁止授权，则重定向后不会带上code参数，仅会带上state参数redirect_uri?state=STATE
         */
        return url;
    }

    /**
     * @Author:Jrss
     * @Desp:获取AccessToken（OAuth专用）
     */
    public static OAuthAccessTokenResult GetAccessToken(String appId, String secret, String code, String grantType) {
        if (grantType == null || grantType.equalsIgnoreCase("")) {
            grantType = "authorization_code";
        }
        String url =
                String.format(GlobalConf.ApiMpHost + "/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=%s",
                        StringHelper.getUrlData(appId),StringHelper.getUrlData(secret), StringHelper.getUrlData(code), StringHelper.getUrlData(grantType));

        return CommonJsonSend.Send < OAuthAccessTokenResult > (null,url, null, CommonJsonSendType.GET);
    }

    /// <summary>
    /// 刷新（OAuth专用）access_token（如果需要）
    /// </summary>
    /// <param name="appId">公众号的唯一标识</param>
    /// <param name="refreshToken">填写通过access_token获取到的refresh_token参数</param>
    /// <param name="grantType">填写refresh_token</param>
    /// <returns></returns>
    public static RefreshTokenResult RefreshToken(string appId, string refreshToken, string grantType ="refresh_token") {
        var url =
                string.Format(Config.ApiMpHost + "/sns/oauth2/refresh_token?appid={0}&grant_type={1}&refresh_token={2}",
                        appId.AsUrlData(), grantType.AsUrlData(), refreshToken.AsUrlData());

        return CommonJsonSend.Send < RefreshTokenResult > (null,url, null, CommonJsonSendType.GET);
    }

    /// <summary>
    /// 获取用户基本信息
    /// </summary>
    /// <param name="oauthAccessToken">调用接口凭证（OAuth专用）</param>
    /// <param name="openId">普通用户的标识，对当前公众号唯一</param>
    /// <param name="lang">返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语</param>
    /// <returns></returns>
    public static OAuthUserInfo GetUserInfo(string oauthAccessToken, string openId, Language lang =Language.zh_CN) {
        var url = string.Format(Config.ApiMpHost + "/sns/userinfo?access_token={0}&openid={1}&lang={2}", oauthAccessToken.AsUrlData(), openId.AsUrlData(), lang.ToString("g").AsUrlData());
        return CommonJsonSend.Send < OAuthUserInfo > (null,url, null, CommonJsonSendType.GET);
    }

    /// <summary>
    /// 检验授权凭证（access_token）是否有效（OAuth专用）
    /// </summary>
    /// <param name="oauthAccessToken">调用接口凭证（OAuth专用）</param>
    /// <param name="openId">用户的唯一标识</param>
    /// <returns></returns>
    public static WxJsonResult Auth(string oauthAccessToken, string openId) {
        var url = string.Format(Config.ApiMpHost + "/sns/auth?access_token={0}&openid={1}", oauthAccessToken.AsUrlData(), openId.AsUrlData());
        return CommonJsonSend.Send < WxJsonResult > (null,url, null, CommonJsonSendType.GET);
    }
}
