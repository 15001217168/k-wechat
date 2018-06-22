package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:单个OpenID红包领取信息
 * @Date:Create in 16:02 2018/6/22
 * @Modified By:
 */
public class RedPackHBInfo {
    /// 领取红包的Openid
    private  String openid;

    ///// 红包状态，SENDING:发放中，SENT:已发放待领取，FAILED：发放失败，RECEIVED:已领取，REFUND:已退款
    //private  String status 

    /// 领取金额
    private  String amount;

    /// 领取时间
    private  String rcv_time;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRcv_time() {
        return rcv_time;
    }

    public void setRcv_time(String rcv_time) {
        this.rcv_time = rcv_time;
    }
}
