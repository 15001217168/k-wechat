package mp.tenPay.entities.result;

import java.util.List;

/**
 * @Author:Jrss
 * @Desp:申请退款接口
 * @Date:Create in 17:22 2018/6/21
 * @Modified By:
 */
public class RefundResult extends Result {
    /*
    错误代码：
            名称  描述 原因  解决方案
            SYSTEMERROR 接口返回错误 系统超时等   请不要更换商户退款单号，请使用相同参数再次调用API。
        TRADE_OVERDUE 订单已经超过退款期限  订单已经超过可退款的最大期限(支付后一年内可退款)   请选择其他方式自行退款
            ERROR   业务错误 申请退款业务发生错误  该错误都会返回具体的错误原因，请根据实际返回做相应处理。
        USER_ACCOUNT_ABNORMAL 退款请求失败  用户帐号注销 此状态代表退款申请失败，商户可自行处理退款。
        INVALID_REQ_TOO_MUCH 无效请求过多  连续错误请求数过多被系统短暂屏蔽 请检查业务是否正常，确认业务正常后请在1分钟后再来重试
            NOTENOUGH   余额不足 商户可用退款余额不足  此状态代表退款申请失败，商户可根据具体的错误提示做相应的处理。
        INVALID_TRANSACTIONID 无效transaction_id    请求参数未按指引进行填写 请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败
            PARAM_ERROR 参数错误 请求参数未按指引进行填写    请求参数错误，请重新检查再调用退款申请
            APPID_NOT_EXIST APPID不存在 参数中缺少APPID  请检查APPID是否正确
            MCHID_NOT_EXIST MCHID不存在 参数中缺少MCHID  请检查MCHID是否正确
            APPID_MCHID_NOT_MATCH   appid和mch_id不匹配 appid和mch_id不匹配 请确认appid和mch_id是否匹配
            REQUIRE_POST_METHOD 请使用post方法 未使用post传递参数     请检查请求参数是否通过post方法提交
            SIGNERROR   签名错误 参数签名结果不正确   请检查签名参数和方法是否都符合签名算法要求
            XML_FORMAT_ERROR    XML格式错误 XML格式错误 请检查XML参数格式是否正确
            FREQUENCY_LIMITED   频率限制	2个月之前的订单申请退款有频率限制 该笔退款未受理，请降低频率后重试
         */
//微信支付分配的终端设备号，与下单一致
    private String device_info;
    //微信订单号
    private String transaction_id;
    //商户订单号
    private String out_trade_no;
    //商户退款单号
    private String out_refund_no;
    //微信退款单号
    private String refund_id;
    //退款金额
    private String refund_fee;
    //应结退款金额
    private String settlement_refund_fee;
    //标价金额
    private String total_fee;
    //应结订单金额
    private String settlement_total_fee;
    //标价币种
    private String fee_type;
    //现金支付金额
    private String cash_fee;
    //现金支付币种
    private String cash_fee_type;
    //现金退款金额
    private String cash_refund_fee;
    //代金券退款总金额
    private String coupon_refund_fee;
    //退款代金券使用数量
    private String coupon_refund_count;
    //代金券类型
    private List<String> coupon_type_n;
    //单个代金券退款金额
    private List<Integer> coupon_refund_fee_n;
    //退款代金券ID
    private List<String> coupon_refund_id_n;

    public RefundResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            super.setResult_code(getXmlValue("result_code"));
            super.setErr_code(getXmlValue("err_code"));
            super.setErr_code_des(getXmlValue("err_code_des"));
            super.setAppid(getXmlValue("appid"));
            super.setMch_id(getXmlValue("mch_id"));
            device_info = getXmlValue("device_info");
            super.setNonce_str(getXmlValue("nonce_str"));
            super.setSign(getXmlValue("sign"));
            transaction_id = getXmlValue("transaction_id");
            out_trade_no = getXmlValue("out_trade_no");
            out_refund_no = getXmlValue("out_refund_no");
            refund_id = getXmlValue("refund_id");
            refund_fee = getXmlValue("refund_fee");
            settlement_refund_fee = getXmlValue("settlement_refund_fee");
            total_fee = getXmlValue("total_fee");
            settlement_total_fee = getXmlValue("settlement_total_fee");
            fee_type = getXmlValue("fee_type");
            cash_fee = getXmlValue("cash_fee");
            cash_fee_type = getXmlValue("cash_fee_type");
            cash_refund_fee = getXmlValue("cash_refund_fee");
            coupon_refund_fee = getXmlValue("coupon_refund_fee");
            coupon_refund_count = getXmlValue("coupon_refund_count");
            coupon_type_n = getXmlValues("coupon_type_n", String.class);
            coupon_refund_fee_n = getXmlValues("coupon_refund_fee_n", Integer.class);
            coupon_refund_id_n = getXmlValues("coupon_refund_id_n", String.class);
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

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getSettlement_refund_fee() {
        return settlement_refund_fee;
    }

    public void setSettlement_refund_fee(String settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
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

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public String getCash_refund_fee() {
        return cash_refund_fee;
    }

    public void setCash_refund_fee(String cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
    }

    public String getCoupon_refund_fee() {
        return coupon_refund_fee;
    }

    public void setCoupon_refund_fee(String coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
    }

    public String getCoupon_refund_count() {
        return coupon_refund_count;
    }

    public void setCoupon_refund_count(String coupon_refund_count) {
        this.coupon_refund_count = coupon_refund_count;
    }

    public List<String> getCoupon_type_n() {
        return coupon_type_n;
    }

    public void setCoupon_type_n(List<String> coupon_type_n) {
        this.coupon_type_n = coupon_type_n;
    }

    public List<Integer> getCoupon_refund_fee_n() {
        return coupon_refund_fee_n;
    }

    public void setCoupon_refund_fee_n(List<Integer> coupon_refund_fee_n) {
        this.coupon_refund_fee_n = coupon_refund_fee_n;
    }

    public List<String> getCoupon_refund_id_n() {
        return coupon_refund_id_n;
    }

    public void setCoupon_refund_id_n(List<String> coupon_refund_id_n) {
        this.coupon_refund_id_n = coupon_refund_id_n;
    }
}
