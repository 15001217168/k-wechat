package mp.tenPay.entities.request.payBank;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:查询企业付款银行卡接口 请求参数
 * @Date:Create in 15:14 2018/6/22
 * @Modified By:
 */
public class TenPayQueryBankRequestData {
    /// 商户号
    private String MchId;

    /// 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
    private String PartnerTradeNumber;

    /// 随机字符串
    private String NonceStr;

    /// Key
    private String Key;

    private RequestHandler PackageRequestHandler;

    /// 通过MD5签名算法计算得出的签名值，详见MD5签名生成算法
    private String Sign;

    public TenPayQueryBankRequestData() {

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("partner_trade_no", this.PartnerTradeNumber); //商户订单号
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);
        PackageRequestHandler.setParameter("sign", Sign); //签名

    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getPartnerTradeNumber() {
        return PartnerTradeNumber;
    }

    public void setPartnerTradeNumber(String partnerTradeNumber) {
        PartnerTradeNumber = partnerTradeNumber;
    }

    public String getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(String nonceStr) {
        NonceStr = nonceStr;
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
