package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[查询订单]
 * @Date:Create in 10:19 2018/6/22
 * @Modified By:
 */
public class TenPayOrderQueryRequestData {
    /// 公众账号ID
    private String AppId;

    /// 子商户公众账号ID
    private String SubAppId;

    /// 商户号
    private String MchId;

    /// 子商户号
    private String SubMchId;

    /// 微信的订单号，建议优先使用
    private String TransactionId;

    ///商户系统内部的订单号，请确保在同一商户号下唯一
    private String OutTradeNo;

    /// 随机字符串
    private String NonceStr;

    /// 签名类型
    private String SignType;

    ///key
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:初始化
     */
    private void initParameter(String appId, String subAppId, String mchId, String subMchId, String transactionId, String nonceStr,
                               String outTradeNo, String key, String signType) {
        AppId = appId;
        SubAppId = subAppId;
        MchId = mchId;
        SubMchId = subMchId;
        NonceStr = nonceStr;
        TransactionId = transactionId;
        OutTradeNo = outTradeNo;
        SignType = signType;
        Key = key;

        PackageRequestHandler = new RequestHandler();

        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameterWhenNotNull("sub_appid", this.SubAppId); //子商户公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameterWhenNotNull("sub_mch_id", this.SubMchId); //子商户号
        PackageRequestHandler.setParameter("transaction_id", this.TransactionId); //微信的订单号
        PackageRequestHandler.setParameter("out_trade_no", this.OutTradeNo); //商户系统内部的订单号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameterWhenNotNull("sign_type", this.SignType); //签名类型
        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);
        PackageRequestHandler.setParameter("sign", Sign); //签名
    }

    /**
     * @Author:Jrss
     * @Desp:查询订单 请求参数[境内服务商]
     */
    public TenPayOrderQueryRequestData(String appId, String subAppId, String mchId, String subMchId, String transactionId, String nonceStr,
                                       String outTradeNo, String key, String signType) {
        initParameter(appId, subAppId, mchId, subMchId, transactionId, nonceStr,
                outTradeNo, key, signType);
    }


    /**
     * @Author:Jrss
     * @Desp:查询订单 请求参数[境内普通商户]
     */
    public TenPayOrderQueryRequestData(String appId, String mchId, String transactionId, String nonceStr,
                                       String outTradeNo, String key, String signType)


    {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        initParameter(appId, null, mchId, null, transactionId, nonceStr, outTradeNo, key, signType);
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getSubAppId() {
        return SubAppId;
    }

    public void setSubAppId(String subAppId) {
        SubAppId = subAppId;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getSubMchId() {
        return SubMchId;
    }

    public void setSubMchId(String subMchId) {
        SubMchId = subMchId;
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

    public String getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(String nonceStr) {
        NonceStr = nonceStr;
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
