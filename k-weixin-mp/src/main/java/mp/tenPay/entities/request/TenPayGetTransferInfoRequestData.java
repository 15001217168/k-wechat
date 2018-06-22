package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[查询企业付款]
 * @Date:Create in 10:12 2018/6/22
 * @Modified By:
 */
public class TenPayGetTransferInfoRequestData {
    /// 公众账号ID [appid]
    private String AppId;

    /// 商户号 [mch_id]
    private String MchId;

    /// 随机字符串 [nonce_str]
    private String NonceStr;

    /// 商户订单号，[partner_trade_no]
    private String PartnerTradeNo;

    /// Key
    private String Key;
    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:查询企业付款
     */
    public TenPayGetTransferInfoRequestData(String appId, String mchId, String nonceStr,
                                            String partnerTradeNo, String key) {
        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        PartnerTradeNo = partnerTradeNo;
        Key = key;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("partner_trade_no", this.PartnerTradeNo); //商户订单号
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("appid", this.AppId); //Appid
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

    public String getPartnerTradeNo() {
        return PartnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        PartnerTradeNo = partnerTradeNo;
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
