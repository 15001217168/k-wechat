package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[撤销订单]
 * @Date:Create in 10:48 2018/6/22
 * @Modified By:
 */
public class TenPayReverseRequestData {
    /// 公众账号ID
    private String AppId;

    /// 商户号
    private String MchId;

    /// 随机字符串
    private String NonceStr;

    /// 微信的订单号，建议优先使用
    private String TransactionId;

    /// 商家订单号
    private String OutTradeNo;

    /// 签名类型
    private String SignType;

    ///
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:撤销订单 请求参数
     */
    public TenPayReverseRequestData(String appId, String mchId, String transactionId, String nonceStr,
                                    String outTradeNo, String key, String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        TransactionId = transactionId;
        SignType = signType;
        OutTradeNo = outTradeNo;
        Key = key;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("transaction_id", this.TransactionId); //微信的订单号
        PackageRequestHandler.setParameter("out_trade_no", this.OutTradeNo); //商户系统内部的订单号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("sign_type", this.SignType); //签名类型
        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);
        PackageRequestHandler.setParameter("sign", Sign); //签名
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

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
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
