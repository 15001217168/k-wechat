package mp.tenPay.entities.request.payBank;

import mp.tenPay.RequestHandler;

/**
 * @Author:Jrss
 * @Desp:付款到银行卡提交数据
 * @Date:Create in 15:11 2018/6/22
 * @Modified By:
 */
public class TenPayPayBankRequestData {
    /// 商户号
    private String MchId;

    /// 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
    private String PartnerTradeNumber;

    /// <para>收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见获取RSA加密公钥API</para>
    /// <para>https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7</para>
    private String EncBankNumber;

    /// <para>收款方用户名（采用标准RSA算法，公钥由微信侧提供）详见获取RSA加密公钥API</para>
    /// <para>https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7</para>
    private String EncTrueName;

    /// <para>收款方开户行。银行卡所在开户行编号,详见银行编号列表</para>
    /// <para>https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_4</para>
    private String BankCode;

    /// 付款金额：RMB分（支付总额，不含手续费）  注：大于0的整数
    private int Amount;

    /// 【非必填】付款说明。企业付款到银行卡付款说明,即订单备注（UTF8编码，允许100个字符以内）
    private String Desc;

    /// 随机字符串
    private String NonceStr;

    /// 商家订单号
    private String OutTradeNo;

    /// 签名类型
    private String SignType;

    /// Key
    private String Key;

    private RequestHandler PackageRequestHandler;

    /// 通过MD5签名算法计算得出的签名值，详见MD5签名生成算法
    private String Sign;

    public TenPayPayBankRequestData() {
        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();
        //设置package订单参数
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr); //随机字符串
        PackageRequestHandler.setParameter("partner_trade_no", this.PartnerTradeNumber); //商户订单号
        PackageRequestHandler.setParameter("mch_id", this.MchId); //商户号
        PackageRequestHandler.setParameter("enc_bank_no", this.EncBankNumber);
        PackageRequestHandler.setParameter("enc_true_name", this.EncTrueName);
        PackageRequestHandler.setParameter("bank_code", this.BankCode);
        PackageRequestHandler.setParameter("amount", this.Amount + "");
        PackageRequestHandler.setParameterWhenNotNull("desc", this.Desc);

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

    public String getEncBankNumber() {
        return EncBankNumber;
    }

    public void setEncBankNumber(String encBankNumber) {
        EncBankNumber = encBankNumber;
    }

    public String getEncTrueName() {
        return EncTrueName;
    }

    public void setEncTrueName(String encTrueName) {
        EncTrueName = encTrueName;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        BankCode = bankCode;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
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
