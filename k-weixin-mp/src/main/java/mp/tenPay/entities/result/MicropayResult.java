package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:刷卡支付,提交被扫支付
 * @Date:Create in 17:45 2018/6/21
 * @Modified By:
 */
public class MicropayResult extends Result {

    /// 调用接口提交的终端设备号
    private String device_info;

    /// 用户在商户appid 下的唯一标识
    private String openid;

    /// 用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
    private String is_subscribe;

    /// 支付类型为MICROPAY(即扫码支付)
    private String trade_type;

    /// 银行类型，采用字符串类型的银行标识
    private String bank_type;

    /// 符合ISO 4217标准的三位字母代码，默认人民币：CNY
    private String fee_type;

    /// 订单总金额，单位为分，只能为整数
    private String total_fee;

    /// 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额
    private String settlement_total_fee;

    /// “代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额
    private String coupon_fee;

    /// 符合ISO 4217标准的三位字母代码，默认人民币：CNY
    private String cash_fee_type;

    /// 订单现金支付金额
    private String cash_fee;

    /// 微信支付订单号
    private String transaction_id;

    /// 商户系统的订单号，与请求一致
    private String out_trade_no;

    /// 商家数据包，原样返回
    private String attach;

    /// 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
    private String time_end;

    public MicropayResult(String resultXml) {

        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            device_info = getXmlValue("device_info");
            if (super.isResultCodeSuccess()) {
                openid = getXmlValue("openid");
                is_subscribe = getXmlValue("is_subscribe");
                trade_type = getXmlValue("trade_type");
                bank_type = getXmlValue("bank_type");
                fee_type = getXmlValue("fee_type");
                total_fee = getXmlValue("total_fee");
                settlement_total_fee = getXmlValue("settlement_total_fee");
                coupon_fee = getXmlValue("coupon_fee");
                cash_fee_type = getXmlValue("cash_fee_type");
                cash_fee = getXmlValue("cash_fee");
                transaction_id = getXmlValue("transaction_id");
                out_trade_no = getXmlValue("out_trade_no");
                attach = getXmlValue("attach");
                time_end = getXmlValue("time_end");
            }
        }
    }
}
