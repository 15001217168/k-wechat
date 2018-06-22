package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[企业付款]
 * @Date:Create in 10:55 2018/6/22
 * @Modified By:
 */
public class TenPayTransfersRequestData {
    /// 微信分配的公众账号ID（企业号corpid即为此appId） [mch_appid]
    private String MchAppId;

    /// 商户号 [mchid]
    private String MchId;

    /// 微信支付分配的终端设备号 [device_info]
    private String DeviceInfo;

    /// 随机字符串 [nonce_str]
    private String NonceStr;

    /// 商家订单号 [partner_trade_no]
    private String OutTradeNo;

    /// 用户openid [openid]
    private String OpenId;

    /// 校验用户姓名选项 [check_name]
    private String CheckName;

    /// 收款用户姓名 [re_user_name]
    private String ReUserName;

    /// 金额 [amount]
    private double Amount;

    /// 企业付款描述信息 [desc]
    private String Desc;

    /// Ip地址 [spbill_create_ip]
    private String SpbillCreateIP;

    ///
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:企业付款
     */
    public TenPayTransfersRequestData(String mchAppid, String mchId, String deviceInfo, String nonceStr, String outTradeNo, String openId, String key, String checkName, String reUserName, double amount, String desc, String spbillCreateIP) {
        MchAppId = mchAppid;
        MchId = mchId;
        DeviceInfo = deviceInfo;
        NonceStr = nonceStr;
        OutTradeNo = outTradeNo;
        OpenId = openId;
        CheckName = checkName;
        ReUserName = reUserName;
        Amount = amount;
        Desc = desc;
        SpbillCreateIP = spbillCreateIP;
        Key = key;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();

        //设置package订单参数
        PackageRequestHandler.setParameter("mch_appid", this.MchAppId); //公众账号appid
        PackageRequestHandler.setParameter("mchid", this.MchId); //商户号
        PackageRequestHandler.setParameter("device_info", this.DeviceInfo); //终端设备号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("partner_trade_no", this.OutTradeNo); //商户订单号
        PackageRequestHandler.setParameter("openid", this.OpenId); //用户openid
        PackageRequestHandler.setParameter("check_name", this.CheckName); //校验用户姓名选项
        PackageRequestHandler.setParameter("re_user_name", this.ReUserName); //收款用户姓名
        PackageRequestHandler.setParameter("amount", ((int) (this.Amount * 100)) + ""); //金额
        PackageRequestHandler.setParameter("desc", this.Desc); //企业付款描述信息
        PackageRequestHandler.setParameter("spbill_create_ip", this.SpbillCreateIP); //Ip地址
        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);
        PackageRequestHandler.setParameter("sign", Sign); //签名
    }

    public String getMchAppId() {
        return MchAppId;
    }

    public void setMchAppId(String mchAppId) {
        MchAppId = mchAppId;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getDeviceInfo() {
        return DeviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        DeviceInfo = deviceInfo;
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

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getCheckName() {
        return CheckName;
    }

    public void setCheckName(String checkName) {
        CheckName = checkName;
    }

    public String getReUserName() {
        return ReUserName;
    }

    public void setReUserName(String reUserName) {
        ReUserName = reUserName;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getSpbillCreateIP() {
        return SpbillCreateIP;
    }

    public void setSpbillCreateIP(String spbillCreateIP) {
        SpbillCreateIP = spbillCreateIP;
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
