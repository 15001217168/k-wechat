package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[获取验签秘钥API]
 * @Date:Create in 18:05 2018/6/21
 * @Modified By:
 */
public class TenPayGetSignKeyRequestData {
    /// 商户号
    private String MchId;

    /// 随机字符串
    private String NonceStr;

    /// 商家订单号
    private String OutTradeNo;

    /// 签名类型
    private String SignType;

    /// Key
    private String Key;

    public RequestHandler PackageRequestHandler;
    public String Sign;

    /**
    *@Author:Jrss
    *@Desp:关闭订单 请求参数
    */
    public TenPayGetSignKeyRequestData(String mchId, String nonceStr, String key, String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        MchId = mchId;
        NonceStr = nonceStr;
        SignType = signType;
        Key = key;
        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();

        //设置package订单参数
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);
        PackageRequestHandler.setParameter("sign", Sign); //签名
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

    public String getOutTradeNo() {
        return OutTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        OutTradeNo = outTradeNo;
    }

    public String getSignType() {
        return SignType;
    }

    public void setSignType(String signType) {
        SignType = signType;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public RequestHandler getPackageRequestHandler() {
        return PackageRequestHandler;
    }

    public void setPackageRequestHandler(RequestHandler packageRequestHandler) {
        PackageRequestHandler = packageRequestHandler;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }
}
