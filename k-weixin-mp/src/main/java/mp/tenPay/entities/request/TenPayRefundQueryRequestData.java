package mp.tenPay.entities.request;

import com.sun.scenario.effect.Offset;
import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[查询退款]
 * @Date:Create in 10:28 2018/6/22
 * @Modified By:
 */
public class TenPayRefundQueryRequestData {
    /// 公众账号ID
    private String AppId;

    /// 商户号，如：1900000109
    private String MchId;

    /// 随机字符串
    private String NonceStr;

    /// 商户自定义的终端设备号，如门店编号、设备的ID
    private String DeviceInfo;

    /// 微信订单号
    private String TransactionId;

    /// 商户系统内部的订单号
    private String OutTradeNo;

    /// 商户侧传给微信的退款单号
    private String OutRefundNo;

    /// 微信生成的退款单号，在申请退款接口有返回
    private String RefundId;

    /// 商品信息
    private String SignType;

    /// （非必填）微信分配的子商户公众账号ID，如：wx8888888888888888
    private String SubAppId;

    /// 微信支付分配的子商户号，如：1900000109
    private String SubMchId;

    /// （非必填）偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录，如：15
    private int Offset;

    /// （非必填）偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:查询退款 请求参数
     */
    public TenPayRefundQueryRequestData(String appId, String mchId, String key, String nonceStr, String deviceInfo,
                                        String transactionId, String outTradeNo, String outRefundNo, String refundId, String subAppid, String subMchId, int offset, String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        DeviceInfo = deviceInfo;
        TransactionId = transactionId;
        OutTradeNo = outTradeNo;
        OutRefundNo = outRefundNo;
        RefundId = refundId;
        SubAppId = subAppid;
        SubMchId = subAppid;
        Offset = offset;
        SignType = signType;
        Key = key;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("device_info", this.DeviceInfo);
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("sign_type", this.SignType);
        PackageRequestHandler.setParameter("transaction_id", this.TransactionId);
        PackageRequestHandler.setParameter("out_trade_no", this.OutTradeNo);
        PackageRequestHandler.setParameter("out_refund_no", this.OutRefundNo);
        PackageRequestHandler.setParameter("refund_id", this.RefundId);
        PackageRequestHandler.setParameterWhenNotNull("sub_appid", this.SubAppId);
        PackageRequestHandler.setParameterWhenNotNull("sub_mch_id", this.SubMchId);
        PackageRequestHandler.setParameterWhenNotNull("offset", this.Offset != 0 ? this.Offset + "" : null);

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

    public String getRefundId() {
        return RefundId;
    }

    public void setRefundId(String refundId) {
        RefundId = refundId;
    }

    public String getSignType() {
        return SignType;
    }

    public void setSignType(String signType) {
        SignType = signType;
    }

    public String getSubAppId() {
        return SubAppId;
    }

    public void setSubAppId(String subAppId) {
        SubAppId = subAppId;
    }

    public String getSubMchId() {
        return SubMchId;
    }

    public void setSubMchId(String subMchId) {
        SubMchId = subMchId;
    }

    public int getOffset() {
        return Offset;
    }

    public void setOffset(int offset) {
        Offset = offset;
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
