package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:企业付款
 * @Date:Create in 17:49 2018/6/21
 * @Modified By:
 */
public class TransfersResult extends TenPayResult {

    /// 商户appid
    private String mch_appid;

    /// 商户号
    private String mchid;

    /// 设备号
    private String device_info;

    /// 随机字符串
    private String nonce_str;

    ///业务结果 SUCCESS/FAIL
    private String result_code;

    /// 错误代码
    private String err_code;

    /// 错误代码描述
    private String err_code_des;

    ///商户订单号
    private String partner_trade_no;

    /// 微信订单号
    private String payment_no;

    /// 微信支付成功时间
    private String payment_time;

    public TransfersResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            mch_appid = getXmlValue("mch_appid");
            mchid = getXmlValue("mchid");
            device_info = getXmlValue("device_info");
            nonce_str = getXmlValue("nonce_str");
            result_code = getXmlValue("result_code");
            err_code = getXmlValue("err_code");
            err_code_des = getXmlValue("err_code_des");
            if (isResultCodeSuccess()) {
                partner_trade_no = getXmlValue("partner_trade_no");
                payment_no = getXmlValue("payment_no");
                payment_time = getXmlValue("payment_time");
            }
        }
    }

    public boolean isResultCodeSuccess() {
        return result_code == "SUCCESS";
    }

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
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

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }
}
