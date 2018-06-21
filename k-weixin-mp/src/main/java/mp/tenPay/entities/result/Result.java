package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:统一支付接口在 return_code为 SUCCESS的时候有返回
 * @Date:Create in 16:53 2018/6/21
 * @Modified By:
 */
public class Result extends TenPayResult {
    private String appid;
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;

    public Result(String xml) {
        super(xml);
        result_code = getXmlValue("result_code"); // res.Element("xml").Element

        if (super.isReturnCodeSuccess()) {
            appid = getXmlValue("appid");
            mch_id = getXmlValue("mch_id");


            sub_appid = getXmlValue("sub_appid");
            sub_mch_id = getXmlValue("sub_mch_id");


            nonce_str = getXmlValue("nonce_str");
            sign = getXmlValue("sign");
            err_code = getXmlValue("err_code");
            err_code_des = getXmlValue("err_code_des");
        }
    }

    /**
     * @Author:Jrss
     * @Desp:esult_code == "SUCCESS"
     */
    public boolean isResultCodeSuccess() {
        return result_code == "SUCCESS";
    }


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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
}
