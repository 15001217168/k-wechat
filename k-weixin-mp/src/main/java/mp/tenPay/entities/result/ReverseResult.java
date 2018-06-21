package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:撤销订单接口
 * @Date:Create in 17:44 2018/6/21
 * @Modified By:
 */
public class ReverseResult extends Result {
    //是否需要继续调用撤销，Y-需要，N-不需要
    private String recall;

    public ReverseResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            recall = getXmlValue("recall");
        }
    }
}
