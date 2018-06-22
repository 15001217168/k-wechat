package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[提交刷卡支付]
 * @Date:Create in 10:15 2018/6/22
 * @Modified By:
 */
public class TenPayMicroPayRequestData {
    /// 公众账号ID
    private String AppId;

    /// 商户号
    private String MchId;

    /// 随机字符串
    private String NonceStr;

    /// 终端设备号(商户自定义，如门店编号)
    private String DeviceInfo;

    /// 商品简单描述，该字段须严格按照规范传递
    private String Body;

    /// 商品详细列表
    private String Detail;

    /// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
    private String Attach;

    /// 商户系统内部的订单号,32个字符内、可包含字母
    private String OutTradeNo;

    /// 订单总金额，单位为分，只能为整数
    private String TotalFee;


    /// 符合ISO4217标准的三位字母代码，默认人民币：CNY
    private String FeeType;

    /// 调用微信支付API的机器IP
    private String SpbillCreateIp;

    /// 商品标记
    private String GoodsTag;

    /// 扫码支付授权码
    private String AuthCode;

    /// 签名类型
    private String SignType;

    ///key
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:提交刷卡支付 请求参数
     */
    public TenPayMicroPayRequestData(String appId, String mchId, String key, String nonceStr, String deviceInfo,
                                     String body, String detail, String attach, String outTradeNo, String totalFee, String feeType,
                                     String spbillCreateIp, String goodsTag, String authCode, String signType) {

        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }

        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        DeviceInfo = deviceInfo;
        Body = body;
        Detail = detail;
        Attach = attach;
        OutTradeNo = outTradeNo;
        TotalFee = totalFee;
        FeeType = feeType;
        SpbillCreateIp = spbillCreateIp;
        GoodsTag = goodsTag;
        AuthCode = authCode;
        SignType = signType;
        Key = key;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("device_info", this.DeviceInfo); //终端设备号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("sign_type", this.SignType); //签名类型
        PackageRequestHandler.setParameter("body", this.Body); //商品简单描述
        PackageRequestHandler.setParameter("detail", this.Detail); //商品详细列表
        PackageRequestHandler.setParameter("attach", this.Attach); //附加数据
        PackageRequestHandler.setParameter("out_trade_no", this.OutTradeNo); //商户系统内部的订单号
        PackageRequestHandler.setParameter("total_fee", this.TotalFee); //订单总金额
        PackageRequestHandler.setParameter("fee_type", this.FeeType); //货币类型
        PackageRequestHandler.setParameter("spbill_create_ip", this.SpbillCreateIp); //终端IP
        PackageRequestHandler.setParameter("goods_tag", this.GoodsTag); //商品标记
        PackageRequestHandler.setParameter("auth_code", this.AuthCode); //授权码
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

    public String getDeviceInfo() {
        return DeviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        DeviceInfo = deviceInfo;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getAttach() {
        return Attach;
    }

    public void setAttach(String attach) {
        Attach = attach;
    }

    public String getOutTradeNo() {
        return OutTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        OutTradeNo = outTradeNo;
    }

    public String getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(String totalFee) {
        TotalFee = totalFee;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public String getSpbillCreateIp() {
        return SpbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        SpbillCreateIp = spbillCreateIp;
    }

    public String getGoodsTag() {
        return GoodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        GoodsTag = goodsTag;
    }

    public String getAuthCode() {
        return AuthCode;
    }

    public void setAuthCode(String authCode) {
        AuthCode = authCode;
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
