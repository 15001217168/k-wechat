package mp.tenPay.entities.result.payBank;

import mp.tenPay.entities.result.Result;
import mp.tenPay.entities.result.TenPayResult;

/**
 * @Author:Jrss
 * @Desp:付款到银行卡返回结果
 * @Date:Create in 15:16 2018/6/22
 * @Modified By:
 */
public class PayBankResult extends TenPayResult {
    /// <para>业务结果</para>
    /// <para>SUCCESS/FAIL，注意：当状态为FAIL时，存在业务结果未明确的情况，所以如果状态y为FAIL，请务必通过查询接口确认此次付款的结果（关注错误码err_code字段）。如果要继续进行这笔付款，请务必用原商户订单号和原参数来重入此接口。</para>
    private String result_code;

    /// <para>错误代码</para>
    /// <para>错误码信息，注意：出现未明确的错误码时，如（SYSTEMERROR）等，请务必用原商户订单号重试，或通过查询接口确认此次付款的结果</para>
    private String err_code;

    /// 错误代码描述
    private String err_code_des;

    /// 商户号
    private String mch_id;

    /// 商户企业付款单号，需要保持唯一
    private String partner_trade_no;

    /// 代付金额RMB:分
    public int amount;

    /// 随机字符串，长度小于32位
    private String nonce_str;

    /// 签名。返回包携带签名给商户
    private String sign;


    // 以下字段在return_code
    //和result_code都为SUCCESS的时候有返回

    /// 微信企业付款单号。代付成功后，返回的内部业务单号
    private String payment_no;

    /// 手续费金额 RMB：分
    private int cmms_amt;
        /*
         *  错误码
        错误代码	原因	解决方案
        INVALID_REQUEST	无效的请求，商户系统异常导致，商户权限异常、证书错误、频率限制等	使用原单号以及原请求参数重试
        SYSTEMERROR	业务错误导致交易失败	请先调用查询接口，查询此次付款结果，如结果为不明确状态（如订单号不存在），请务必使用原商户订单号及原请求参数重试
        PARAM_ERROR	参数错误，商户系统异常导致	商户检查请求参数是否合法，证书，签名
        SIGNERROR	签名错误	按照文档签名算法进行签名值计算
        AMOUNT_LIMIT	超额；已达到今日付款金额上限或已达到今日银行卡收款金额上限	今天暂停该商户发起代付请求或今日暂停向该银行卡转账
        ORDERPAID	受理失败，订单已存在	请通过查询接口确认订单信息
        FATAL_ERROR	已存在该单，并且订单信息不一致；或订单太老	核定订单信息
        NOTENOUGH	账号余额不足	请用户充值或更换支付卡后再支付
        FREQUENCY_LIMITED	超过每分钟600次的频率限制	稍后用原单号重试
        SUCCESS	Wx侧受理成功
        */

    /**
     * @Author:Jrss
     * @Desp:付款到银行卡返回结果 构造函数
     */
    public PayBankResult(String resultXml) {
        super(resultXml);
        err_code_des = getXmlValue("err_code_des");
        mch_id = getXmlValue("mch_id");
        partner_trade_no = getXmlValue("partner_trade_no");
        amount = Integer.parseInt(getXmlValue("amount"));//必填
        nonce_str = getXmlValue("nonce_str");
        sign = getXmlValue("sign");


        if (super.isReturnCodeSuccess() && this.isResultCodeSuccess()) {
            payment_no = getXmlValue("payment_no");
            cmms_amt = Integer.parseInt(getXmlValue("cmms_amt"));//必填
        }
    }

    public boolean isResultCodeSuccess() {
        return result_code == "SUCCESS";
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public int getCmms_amt() {
        return cmms_amt;
    }

    public void setCmms_amt(int cmms_amt) {
        this.cmms_amt = cmms_amt;
    }
}
