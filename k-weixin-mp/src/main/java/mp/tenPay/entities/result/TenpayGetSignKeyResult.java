package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:获取验签秘钥API 返回结果
 * @Date:Create in 17:54 2018/6/21
 * @Modified By:
 */
public class TenpayGetSignKeyResult extends TenPayResult {
    /// 微信支付分配的微信商户号
    private String mch_id;

    /// 返回的沙箱密钥
    private String sandbox_signkey;

    /// 获取验签秘钥API 返回结果 构造函数
    public TenpayGetSignKeyResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            mch_id = getXmlValue("mch_id");
            sandbox_signkey = getXmlValue("sandbox_signkey");
        }
    }
}
