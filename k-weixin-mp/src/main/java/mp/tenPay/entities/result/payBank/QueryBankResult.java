package mp.tenPay.entities.result.payBank;

import mp.tenPay.entities.result.TenPayResult;

/**
 * @Author:Jrss
 * @Desp:查询付款到银行卡返回结果
 * @Date:Create in 15:22 2018/6/22
 * @Modified By:
 */
public class QueryBankResult extends TenPayResult {

    //以下字段在return_code为SUCCESS的时候有返回

    /// <para>业务结果</para>
    /// <para>SUCCESS/FAIL，注意：当状态为FAIL时，存在业务结果未明确的情况，所以如果状态y为FAIL，请务必通过查询接口确认此次付款的结果（关注错误码err_code字段）。如果要继续进行这笔付款，请务必用原商户订单号和原参数来重入此接口。</para>
    private String result_code;


    /// <para>错误代码</para>
    /// <para>错误码信息，注意：出现未明确的错误码时，如（SYSTEMERROR）等，请务必用原商户订单号重试，或通过查询接口确认此次付款的结果</para>
    private String err_code;

    /// 错误代码描述
    private String err_code_des;

    // 以下字段在return_code 和result_code都为SUCCESS的时候有返回

    /// 商户号
    private String mch_id;

    /// 商户企业付款单号，需要保持唯一
    private String partner_trade_no;

    /// 微信企业付款单号
    private String payment_no;

    /// 收款用户银行卡号(MD5加密)
    private String bank_no_md5;

    /// 收款人真实姓名（MD5加密）
    private String true_name_md5;

    /// 代付订单金额RMB：分
    private int amount;

    /// <para>代付单状态</para>
    /// <para>代付订单状态：PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）</para>
    /// <para>SUCCESS（付款成功）</para>
    /// <para>FAILED（付款失败,需要替换付款单号重新发起付款）</para>
    /// <para>BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还）</para>
    private String status;

    /// 手续费订单金额 RMB：分
    private int cmms_amt;

    /// 商户下单时间（微信侧订单创建时间）
    private String create_time;

    /// 成功付款时间（但无法保证银行不会退票）
    private String pay_succ_time;

    /// 订单失败原因（如：余额不足）
    private String reason;

        /*
         * 错误码
        错误代码	描述	解决方案
        INVALID_REQUEST	无效的请求，商户系统异常导致，商户权限异常、证书错误、频率限制等	使用原单号以及原请求参数重试
        PARAM_ERROR	参数错误	按照err_msg指定参数错误信息，修改相应参数
        SIGNERROR	签名错误	签名前没有按照要求进行排序。没有使用商户平台设置的密钥进行签名，参数有空格或者进行了encode后进行签名
        ORDERNOTEXIST	订单不存在	确认订单号是否发起过请求
        SYSTEMERROR	系统繁忙，请稍后重试	使用原单号以及原请求参数重试
        SUCCESS	Wx侧查询成功
        */

    /**
     * @Author:Jrss
     * @Desp:付款到银行卡返回结果 构造函数
     */
    public QueryBankResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            result_code = getXmlValue("result_code");
            err_code = getXmlValue("err_code");
            err_code_des = getXmlValue("err_code_des");

            if (this.isResultCodeSuccess()) {
                mch_id = getXmlValue("mch_id");
                partner_trade_no = getXmlValue("partner_trade_no");
                payment_no = getXmlValue("payment_no");
                bank_no_md5 = getXmlValue("bank_no_md5");
                true_name_md5 = getXmlValue("true_name_md5");
                amount = Integer.parseInt(getXmlValue("amount"));//必填
                status = getXmlValue("status");
                cmms_amt = Integer.parseInt(getXmlValue("cmms_amt"));//必填
                create_time = getXmlValue("create_time");
                pay_succ_time = getXmlValue("pay_succ_time");
                reason = getXmlValue("reason");
            }
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

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getBank_no_md5() {
        return bank_no_md5;
    }

    public void setBank_no_md5(String bank_no_md5) {
        this.bank_no_md5 = bank_no_md5;
    }

    public String getTrue_name_md5() {
        return true_name_md5;
    }

    public void setTrue_name_md5(String true_name_md5) {
        this.true_name_md5 = true_name_md5;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCmms_amt() {
        return cmms_amt;
    }

    public void setCmms_amt(int cmms_amt) {
        this.cmms_amt = cmms_amt;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPay_succ_time() {
        return pay_succ_time;
    }

    public void setPay_succ_time(String pay_succ_time) {
        this.pay_succ_time = pay_succ_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
