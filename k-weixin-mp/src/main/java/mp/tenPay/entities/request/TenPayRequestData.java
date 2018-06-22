package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据的基类
 * @Date:Create in 10:38 2018/6/22
 * @Modified By:
 */
public class TenPayRequestData {

    /// 公众账号ID
    private String AppId;

    /// 商户号
    private String MchId;

    /// 随机字符串
    private String NonceStr;

    private RequestHandler PackageRequestHandler;

    ///key
    private String Key;

    /**
     * @Author:Jrss
     * @Desp:
     */
    public TenPayRequestData(String appId, String mchId, String key,
                              String nonceStr) {
        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        Key = key;

        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(String nonceStr) {
        NonceStr = nonceStr;
    }

    public RequestHandler getPackageRequestHandler() {
        return PackageRequestHandler;
    }

    public void setPackageRequestHandler(RequestHandler packageRequestHandler) {
        PackageRequestHandler = packageRequestHandler;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
