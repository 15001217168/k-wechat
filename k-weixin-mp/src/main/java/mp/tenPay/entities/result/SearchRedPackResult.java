package mp.tenPay.entities.result;

import java.util.List;

/**
 * @Author:Jrss
 * @Desp:获取查询红包接口的结果，既可以查询普通红包，也可以查询裂变红包
 * @Date:Create in 16:01 2018/6/22
 * @Modified By:
 */
public class SearchRedPackResult {
    /// 返回状态码,SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
    private boolean return_code;

    /// 返回信息，如非空，为错误原因,签名失败,参数格式校验错误
    private String return_msg;


    /// 业务结果,SUCCESS/FAIL
    private boolean result_code;


    /// 错误代码
    private String err_code;

    /// 错误代码描述
    private String err_code_des;

    /// 商户订单号（每个订单号必须唯一） 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
    private String mch_billno;

    /// 商户号，微信支付分配的商户号
    private String mch_id;

    /// 红包单号
    private String detail_id;

    /// 红包状态，SENDING:发放中，SENT:已发放待领取，FAILED：发放失败，RECEIVED:已领取，REFUND:已退款
    private String status;

    /// 发放类型,API:通过API接口发放,UPLOAD:通过上传文件方式发放,ACTIVITY:通过活动方式发放
    private String send_type;

    /// 红包类型,GROUP:裂变红包,NORMAL:普通红包
    private String hb_type;

    /// 红包个数
    private String total_num;

    /// 红包总金额（单位分）
    private String total_amount;

    /// 红包发送时间
    private String send_time;

    /// 祝福语
    private String wishing;

    /// 活动描述，低版本微信可见
    private String remark;

    /// 活动名称（请注意活动名称长度，官方文档提示为32个字符，实际限制不足32个字符）
    private String act_name;

    /// 发送失败原因
    private String reason;

    /// 红包的退款时间（如果其未领取的退款）
    private String refund_time;

    /// 红包退款金额
    private String refund_amount;

    /// 红包领取列表,普通红包只有一项，列表红包可以有很多项
    public List<RedPackHBInfo> hblist;
}
