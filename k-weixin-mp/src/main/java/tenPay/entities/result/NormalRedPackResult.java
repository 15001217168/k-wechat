package tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:获取普通现金红包发送接口的结果
 * @Date:Create in 17:19 2018/6/20
 * @Modified By:
 */
public class NormalRedPackResult {
    //返回状态码
    private String return_code;
    //判断return_code是否为SUCCESS返回值
    private boolean returnCodeSuccess;
    //返回信息，返回信息，如非空，为错误原因，签名失败，参数格式校验错误
    private String return_msg;
    //业务结果,SUCCESS/FAIL
    private String result_code;
    //判断result_code是否为SUCCESS返回值
    private boolean resultCodeSuccess;
    //错误代码
    private String err_code;
    //错误代码描述
    private String err_code_des;
    //商户订单号（每个订单号必须唯一） 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
    private String mch_billno;
    //商户号，微信支付分配的商户号
    private String mch_id;
    //公众账号appid。商户appid，接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）。
    private String wxappid;
    //用户openid
    private String re_openid;
    //付款金额，单位分
    private String total_amount;
    //发放成功时间,格式20150520102602
    private String send_time;
    //红包订单的微信单号
    private String send_listid;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public boolean isReturnCodeSuccess() {
        return return_code.toUpperCase() == "SUCCESS";
    }

    public void setReturnCodeSuccess(boolean returnCodeSuccess) {
        this.returnCodeSuccess = returnCodeSuccess;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public boolean isResultCodeSuccess() {
        return result_code.toUpperCase() == "SUCCESS";
    }

    public void setResultCodeSuccess(boolean resultCodeSuccess) {
        this.resultCodeSuccess = resultCodeSuccess;
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

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getSend_listid() {
        return send_listid;
    }

    public void setSend_listid(String send_listid) {
        this.send_listid = send_listid;
    }
}
