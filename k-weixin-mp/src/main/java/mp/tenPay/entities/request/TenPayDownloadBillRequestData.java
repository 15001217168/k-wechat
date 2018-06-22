package mp.tenPay.entities.request;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:微信支付提交的XML Data数据[下载对账单]
 * @Date:Create in 10:07 2018/6/22
 * @Modified By:
 */
public class TenPayDownloadBillRequestData {
    //公众账号ID [appid]
    private String AppId;
    //商户号 [mch_id]
    private String MchId;
    //设备信息 [device_info]
    private String DeviceInfo;
    //随机字符串
    private String NonceStr;
    //签名类型
    private String SignType;
    //对账单日期	[bill_date]
    private String BillDate;
    ///账单类型	[bill_type]
    private String BillType;
    //压缩账单	[tar_type]
    private String TarType;
    //Key
    private String Key;
    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:下载对账单
     */
    public TenPayDownloadBillRequestData(String appId, String mchId, String nonceStr, String deviceInfo,
                                         String billDate, String billType, String key, String tarType, String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        if (tarType == null || tarType.equalsIgnoreCase("")) {
            tarType = "GZIP";
        }
        PackageRequestHandler = new RequestHandler();

        AppId = appId;
        MchId = mchId;
        NonceStr = nonceStr;
        DeviceInfo = deviceInfo;
        BillDate = billDate;
        BillType = billType;
        SignType = signType;
        TarType = tarType;
        Key = key;

        //设置package订单参数
        PackageRequestHandler.setParameter("appid", this.AppId); //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("device_info", this.DeviceInfo); //设备号
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("sign_type", this.SignType); //签名类型
        PackageRequestHandler.setParameter("bill_date", this.BillDate); //对账单日期
        PackageRequestHandler.setParameter("bill_type", this.BillType); //账单类型
        PackageRequestHandler.setParameter("tar_type", this.TarType); //压缩账单

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

    public String getSignType() {
        return SignType;
    }

    public void setSignType(String signType) {
        SignType = signType;
    }

    public String getBillDate() {
        return BillDate;
    }

    public void setBillDate(String billDate) {
        BillDate = billDate;
    }

    public String getBillType() {
        return BillType;
    }

    public void setBillType(String billType) {
        BillType = billType;
    }

    public String getTarType() {
        return TarType;
    }

    public void setTarType(String tarType) {
        TarType = tarType;
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
