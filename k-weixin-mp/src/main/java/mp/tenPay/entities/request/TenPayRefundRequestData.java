package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp: 微信支付提交的XML Data数据[申请退款]
 * @Date:Create in 10:33 2018/6/22
 * @Modified By:
 */
public class TenPayRefundRequestData {
    /// 公众账号ID
    private String AppId;

    /// 商户号
    private String MchId;


    /// 商户自定义的终端设备号，如门店编号、设备的ID
    private String DeviceInfo;

    /// 随机字符串
    private String NonceStr;

    /// 微信订单号（和OutTradeNo二选一）
    private String TransactionId;

    /// 商户系统内部的订单号（和TransactionId二选一）
    private String OutTradeNo;

    /// 商户侧传给微信的退款单号
    private String OutRefundNo;

    /// 订单金额。订单总金额，单位为分，只能为整数，详见支付金额
    private int TotalFee;

    /// 退款金额。退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
    private int RefundFee;

    /// 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String RefundFeeType;

    /// 操作员，操作员帐号, 默认为商户号
    private String OpUserId;

    /// 退款资金来源。仅针对老资金流商户使用
    /// REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
    /// REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款(限非当日交易订单的退款）
    private String RefundAccount;

    /// 若商户传入，会在下发给用户的退款消息中体现退款原因
    private String RefundDescription;

    /// 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数。
    /// 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
    private String NotifyUrl;

    /// 签名类型
    private String SignType;

    ///
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;


    /**
     * @Author:Jrss
     * @Desp:申请退款 请求参数
     */
    public TenPayRefundRequestData(String appId, String mchId, String key, String deviceInfo, String nonceStr,
                                   String transactionId, String outTradeNo, String outRefundNo, int totalFee, int refundFee,
                                   String opUserId, String refundAccount, String refundDescription, String notifyUrl,
                                   String refundFeeType, String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        if (refundFeeType == null || refundFeeType.equalsIgnoreCase("")) {
            refundFeeType = "CNY";
        }
        AppId = appId;
        MchId = mchId;
        Key = key;
        NonceStr = nonceStr;
        DeviceInfo = deviceInfo;
        TransactionId = transactionId;
        OutTradeNo = outTradeNo;
        OutRefundNo = outRefundNo;
        TotalFee = totalFee;
        RefundFee = refundFee;
        OpUserId = opUserId;
        RefundFeeType = refundFeeType;
        RefundAccount = refundAccount;
        RefundDescription = refundDescription;
        NotifyUrl = notifyUrl;

        SignType = signType;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameterWhenNotNull("device_info", this.DeviceInfo);
        PackageRequestHandler.setParameter("sign_type", this.SignType);
        PackageRequestHandler.setParameterWhenNotNull("transaction_id", this.TransactionId);
        PackageRequestHandler.setParameterWhenNotNull("out_trade_no", this.OutTradeNo);
        PackageRequestHandler.setParameter("out_refund_no", this.OutRefundNo);
        PackageRequestHandler.setParameter("total_fee", this.TotalFee + "");
        PackageRequestHandler.setParameter("refund_fee", this.RefundFee + "");
        PackageRequestHandler.setParameter("op_user_id", this.OpUserId);
        PackageRequestHandler.setParameterWhenNotNull("refund_fee_type", this.RefundFeeType);
        PackageRequestHandler.setParameterWhenNotNull("refund_desc", this.RefundDescription);
        PackageRequestHandler.setParameterWhenNotNull("notify_url", this.NotifyUrl);
        PackageRequestHandler.setParameterWhenNotNull("refund_account", this.RefundAccount);
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

    public String getOutRefundNo() {
        return OutRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        OutRefundNo = outRefundNo;
    }

    public int getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(int totalFee) {
        TotalFee = totalFee;
    }

    public int getRefundFee() {
        return RefundFee;
    }

    public void setRefundFee(int refundFee) {
        RefundFee = refundFee;
    }

    public String getRefundFeeType() {
        return RefundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        RefundFeeType = refundFeeType;
    }

    public String getOpUserId() {
        return OpUserId;
    }

    public void setOpUserId(String opUserId) {
        OpUserId = opUserId;
    }

    public String getRefundAccount() {
        return RefundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        RefundAccount = refundAccount;
    }

    public String getRefundDescription() {
        return RefundDescription;
    }

    public void setRefundDescription(String refundDescription) {
        RefundDescription = refundDescription;
    }

    public String getNotifyUrl() {
        return NotifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        NotifyUrl = notifyUrl;
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
