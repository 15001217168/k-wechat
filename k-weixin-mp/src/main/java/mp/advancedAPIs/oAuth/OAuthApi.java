package mp.advancedAPIs.oAuth;

import mp.advancedAPIs.oAuth.oAuthJson.OAuthAccessTokenResult;
import mp.advancedAPIs.oAuth.oAuthJson.OAuthUserInfo;
import mp.advancedAPIs.oAuth.oAuthJson.RefreshTokenResult;
import mp.commonAPIs.CommonJsonSend;
import mp.emums.EnumsOAuthScope;
import weixin.GlobalConf;
import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.CommonJsonSendType;
import weixin.helpers.StringHelper;

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
                        StringHelper.getUrlData(appId), StringHelper.getUrlData(secret), StringHelper.getUrlData(code), StringHelper.getUrlData(grantType));

        return (OAuthAccessTokenResult) CommonJsonSend.send(null, url, null, CommonJsonSendType.GET, 0, true);
    }

    /**
     * @Author:Jrss
     * @Desp:刷新（OAuth专用）access_token（如果需要）
     */
    public static RefreshTokenResult RefreshToken(String appId, String refreshToken, String grantType) {
        if (grantType == null || grantType.equalsIgnoreCase("")) {
            grantType = "refresh_token";
        }
        String url =
                String.format(GlobalConf.ApiMpHost + "/sns/oauth2/refresh_token?appid=%s&grant_type=%s&refresh_token=%s",
                        StringHelper.getUrlData(appId), StringHelper.getUrlData(grantType), StringHelper.getUrlData(refreshToken));

        return (RefreshTokenResult) CommonJsonSend.send(null, url, null, CommonJsonSendType.GET, 0, true);
    }

    /**
     * @Author:Jrss
     * @Desp:获取用户基本信息
     */
    public static OAuthUserInfo GetUserInfo(String oauthAccessToken, String openId, String lang) {
        String url = String.format(GlobalConf.ApiMpHost + "/sns/userinfo?access_token=%s&openid=%s&lang=%s", StringHelper.getUrlData(oauthAccessToken), StringHelper.getUrlData(openId), StringHelper.getUrlData(lang));
        return (OAuthUserInfo) CommonJsonSend.doSend(null, url, null, CommonJsonSendType.GET, 0, true);
    }

    /**
     * @Author:Jrss
     * @Desp:检验授权凭证（access_token）是否有效（OAuth专用）
     */
    public static WxJsonResult Auth(String oauthAccessToken, String openId) {
        String url = String.format(GlobalConf.ApiMpHost + "/sns/auth?access_token=%s&openid=%s", StringHelper.getUrlData(oauthAccessToken), StringHelper.getUrlData(openId));
        return CommonJsonSend.send(null, url, null, CommonJsonSendType.GET, 0, true);
    }
}
