package mp.tenPay.entities.request.serviceProvider;

import mp.tenPay.entities.request.TenPayMicroPayRequestData;

/**
 * @Author:Jrss
 * @Desp:境内服务商】微信支付提交的XML Data数据[提交刷卡支付]
 * @Date:Create in 15:51 2018/6/22
 * @Modified By:
 */
public class TenPayMicroPayRequestDataService extends TenPayMicroPayRequestData {
    /// String(32)	wx8888888888888888	微信分配的子商户公众账号ID
    private String SubAppId;

    /// String(32)	1900000109	微信支付分配的子商户号，开发者模式下必填
    private String SubMchId;

    /**
     * @Author:Jrss
     * @Desp:提交刷卡支付 请求参数
     */
    public TenPayMicroPayRequestDataService(String appId, String mchId,
                                            String sub_appid,
                                            String sub_mch_id,
                                            String key, String nonceStr, String deviceInfo,
                                            String body, String detail, String attach, String outTradeNo, String totalFee, String feeType,
                                            String spbillCreateIp, String goodsTag, String authCode, String signType) {
        super(appId, mchId, key, nonceStr, deviceInfo, body, detail, attach, outTradeNo, totalFee, feeType, spbillCreateIp, goodsTag, authCode, signType);

        SubAppId = sub_appid;
        SubMchId = sub_mch_id;

        super.getPackageRequestHandler().setParameter("sub_appid", this.SubAppId); //微信分配的子商户公众账号ID

        super.getPackageRequestHandler().setParameter("sub_mch_id", this.SubMchId); //微信支付分配的子商户号，开发者模式下必填

        super.setSign(super.getPackageRequestHandler().createMd5Sign("key", super.getKey()));
        super.getPackageRequestHandler().setParameter("sign", super.getSign()); //签名
    }

    public String getSubAppId() {
        return SubAppId;
    }

    public void setSubAppId(String subAppId) {
        SubAppId = subAppId;
    }

    public String getSubMchId() {
        return SubMchId;
    }

    public void setSubMchId(String subMchId) {
        SubMchId = subMchId;
    }
}
