package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:退款查询接口
 * @Date:Create in 17:38 2018/6/21
 * @Modified By:
 */
public class RefundQueryResult extends Result {
    //终端设备号
    private String device_info;
    //微信订单号
    private String transaction_id;
    //商户系统内部的订单号
    private String out_trade_no;
    //订单总金额，单位为分，只能为整数
    private String total_fee;
    //应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额
    private String settlement_total_fee;
    //订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
    private String fee_type;
    //现金支付金额，单位为分，只能为整数
    private String cash_fee;
    //退款记录数
    private String refund_count;
    /// REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
    //REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
    private String refund_account;

    public RefundQueryResult(String resultXml) {
        super(resultXml);
        if (super.isResultCodeSuccess()) {
            device_info = getXmlValue("device_info");
            transaction_id = getXmlValue("transaction_id");
            out_trade_no = getXmlValue("out_trade_no");
            total_fee = getXmlValue("total_fee");
            settlement_total_fee = getXmlValue("settlement_total_fee");
            fee_type = getXmlValue("fee_type");
            cash_fee = getXmlValue("cash_fee");
            refund_count = getXmlValue("refund_count");
            refund_account = getXmlValue("refund_account");
        }
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(String settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getRefund_count() {
        return refund_count;
    }

    public void setRefund_count(String refund_count) {
        this.refund_count = refund_count;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account(String refund_account) {
        this.refund_account = refund_account;
    }
}
