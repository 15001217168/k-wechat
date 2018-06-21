package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:关闭订单接口
 * @Date:Create in 17:20 2018/6/21
 * @Modified By:
 */
public class CloseOrderResult extends Result {
    //对于业务执行的详细描述
    private String result_msg;

    public CloseOrderResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            result_msg = getXmlValue("result_msg");
        }
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }
}
