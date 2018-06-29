package mp.entities.jsonResult;

import weixin.entities.jsonResult.WxJsonResult;

/**
 * @Author:Jrss
 * @Desp:access_token请求后的JSON返回格式
 * @Date:Create in 14:20 2018/6/26
 * @Modified By:
 */
public class AccessTokenResult extends WxJsonResult {
    /// 获取到的凭证
    private String access_token;
    /// 凭证有效时间，单位：秒
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
