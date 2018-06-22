package mp.tenPay.entities.result.payBank;

import mp.tenPay.entities.result.TenPayResult;

/**
 * @Author:Jrss
 * @Desp:获取 RSA 加密公钥接口 返回结果
 * @Date:Create in 15:29 2018/6/22
 * @Modified By:
 */
public class GetPublicKeyResult extends TenPayResult {

    // 以下字段在return_code为SUCCESS的时候有返回
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

    /// 密钥（RSA 公钥）
    private String pub_key;

    /**
     * @Author:Jrss
     * @Desp:获取 RSA 加密公钥接口 返回结果 构造函数
     */
    public GetPublicKeyResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {

            result_code = getXmlValue("result_code");
            err_code = getXmlValue("err_code");
            err_code_des = getXmlValue("err_code_des");

            if (this.isResultCodeSuccess()) {
                mch_id = getXmlValue("mch_id");
                pub_key = getXmlValue("pub_key");
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

    public String getPub_key() {
        return pub_key;
    }

    public void setPub_key(String pub_key) {
        this.pub_key = pub_key;
    }
}
