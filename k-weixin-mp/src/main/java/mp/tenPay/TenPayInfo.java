package mp.tenPay;

/**
 * @Author:Jrss
 * @Desp:微信支付基础信息储存类
 * @Date:Create in 13:45 2018/6/21
 * @Modified By:
 */
public class TenPayInfo {
    //第三方用户唯一凭证appid
    private  String AppId;
    //第三方用户唯一凭证密钥，即appsecret
    private  String AppSecret;
    // 商户ID
    private  String MchId;
    //商户支付密钥Key。登录微信商户后台，进入栏目【账户设置】【密码安全】【API 安全】【API 密钥】
    private  String Key;
    //支付完成后的回调处理页面
    private String TenPayNotify;

    public TenPayInfo(String appId, String appSecret, String mchId, String key, String tenPayNotify) {
        AppId = appId;
        AppSecret = appSecret;
        MchId = mchId;
        Key = key;
        TenPayNotify = tenPayNotify;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getAppSecret() {
        return AppSecret;
    }

    public void setAppSecret(String appSecret) {
        AppSecret = appSecret;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getTenPayNotify() {
        return TenPayNotify;
    }

    public void setTenPayNotify(String tenPayNotify) {
        TenPayNotify = tenPayNotify;
    }
}
