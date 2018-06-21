package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:统一支付接口在return_code 和result_code 都为SUCCESS 的时候有返回详细信息
 * @Date:Create in 16:58 2018/6/21
 * @Modified By:
 */
public class UnifiedorderResult extends Result {
    //微信支付分配的终端设备号
    private String device_info;
    //交易类型:JSAPI、NATIVE、APP
    private String trade_type;
    //微信生成的预支付ID，用于后续接口调用中使用
    private String prepay_id;
    //trade_type为NATIVE时有返回，此参数可直接生成二维码展示出来进行扫码支付
    private String code_url;
    //在H5支付时返回
    private String mweb_url;


    public UnifiedorderResult(String xml) {
        super(xml);
        if (super.isReturnCodeSuccess()) {
            device_info = getXmlValue("device_info");
            //sub_appid = GetXmlValue("sub_appid") ?? "";
            //sub_mch_id = GetXmlValue("sub_mch_id") ?? "";

            if (super.isResultCodeSuccess()) {
                trade_type = getXmlValue("trade_type");
                prepay_id = getXmlValue("prepay_id");
                code_url = getXmlValue("code_url");
                mweb_url = getXmlValue("mweb_url");
            }
        }
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getMweb_url() {
        return mweb_url;
    }

    public void setMweb_url(String mweb_url) {
        this.mweb_url = mweb_url;
    }
}
