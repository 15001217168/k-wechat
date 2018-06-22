package mp.tenPay.entities.request;

import mp.emums.TenPayType;
import mp.tenPay.RequestHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author:Jrss
 * @Desp: 微信支付提交的XML Data数据[统一下单]
 * @Date:Create in 10:59 2018/6/22
 * @Modified By:
 */
public class TenPayUnifiedorderRequestData {
    /// 公众账号ID
    private String AppId;

    /// 商户号
    private String MchId;

    /// 子商户公众账号ID sub_appid
    private String SubAppId;

    /// 子商户号 sub_mch_id  是 String(32)  1900000109	微信支付分配的子商户号
    private String SubMchId;

    /// 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"，String(32)如：013467007045764
    private String DeviceInfo;

    /// 随机字符串
    private String NonceStr;
    /// 签名类型，默认为MD5，支持HMAC-SHA256和MD5。（使用默认）
    private String SignType;
    /// 商品信息
    private String Body;

    /// 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。
    ///cost_price Int 可选 32 订单原价，商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的支付金额。当订单原价与支付金额不相等则被判定为拆单，无法享/受/优/惠。
    /// receipt_id String 可选 32 商家小票ID
    ///goods_detail 服务商必填[]：
    ///└ goods_id String 必填 32 商品的编号
    ///└ wxpay_goods_id String 可选 32 微信支付定义的统一商品编号
    ///└ goods_name String 可选 256 商品名称
    ///└ quantity Int 必填  32 商品数量
    ///└ price Int 必填 32 商品单价，如果商户有优惠，需传输商户优惠后的单价
    ///注意：单品总金额应&lt;=订单总金额total_fee，否则会无法享受优惠。
    /// String(6000)
    private String Detail;

    /// 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。String(127)，如：深圳分店
    private String Attach;

    /// 符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型。String(16)，如：CNY
    private String FeeType;

    /// 商家订单号
    private String OutTradeNo;

    /// 商品金额,以分为单位(money * 100).ToString()
    private int TotalFee;

    /// 用户的公网ip，不是商户服务器IP
    private String SpbillCreateIP;

    /// 订单生成时间，最终生成格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则。
    /// 如果为空，则默认为当前服务器时间
    private String TimeStart;

    /// 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
    /// 注意：最短失效时间间隔必须大于5分钟。
    /// 留空则不设置失效时间
    private String TimeExpire;

    /// 商品标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠。String(32)，如：WXG
    private String GoodsTag;

    /// 接收财付通通知的URL
    private String NotifyUrl;

    /// 交易类型
    private TenPayType TradeType;

    /// trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    /// String(32)，如：12235413214070356458058
    private String ProductId;

    /// 上传此参数no_credit--可限制用户不能使用信用卡支付
    private String LimitPay;

    /// 用户的openId
    private String OpenId;

    /// 该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }
    private TenPayUnifiedorderRequestDataSceneInfo SceneInfo;

    /// 用户子标识
    private String SubOpenid;

    ///
    private String Key;

    private RequestHandler PackageRequestHandler;
    private String Sign;

    /**
     * @Author:Jrss
     * @Desp:普通商户
     */
    public TenPayUnifiedorderRequestData(
            String appId, String mchId, String body, String outTradeNo, int totalFee, String spbillCreateIp,
            String notifyUrl, TenPayType tradeType, String openid, String key, String nonceStr,
            String deviceInfo, Calendar timeStart, Calendar timeExpire,
            String detail, String attach, String feeType, String goodsTag,
            String productId, boolean limitPay,
            TenPayUnifiedorderRequestDataSceneInfo sceneInfo
    ) {
        initParameter(appId, mchId, null, null, body, outTradeNo, totalFee, spbillCreateIp,
                notifyUrl, tradeType, openid, null, key, nonceStr,
                deviceInfo, timeStart, timeExpire, detail, attach, feeType, goodsTag,
                productId, limitPay,
                sceneInfo);
    }

    /**
     * @Author:Jrss
     * @Desp:初始化
     */
    private void initParameter(
            String appId, String mchId, String subappid, String submchid, String body, String outTradeNo, int totalFee, String spbillCreateIp,
            String notifyUrl, TenPayType tradeType, String openid, String subOpenid, String key, String nonceStr,
            String deviceInfo, Calendar timeStart, Calendar timeExpire,
            String detail, String attach, String feeType, String goodsTag,
            String productId, boolean limitPay,
            TenPayUnifiedorderRequestDataSceneInfo sceneInfo
    ) {
        if (feeType == null || feeType.equalsIgnoreCase("")) {
            feeType = "CNY";
        }
        AppId = appId;
        MchId = mchId;
        DeviceInfo = deviceInfo;
        NonceStr = nonceStr;
        SignType = "MD5";
        Body = body.equalsIgnoreCase("") ? "k-Tenpay" : body;
        Detail = detail;
        Attach = attach;
        OutTradeNo = outTradeNo;
        FeeType = feeType;
        TotalFee = totalFee;
        SpbillCreateIP = spbillCreateIp;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        TimeStart = format.format((timeStart == null ? Calendar.getInstance().getTime() : timeStart.getTime()));
        TimeExpire = timeExpire != null ? format.format(timeExpire.getTime()) : null;
        GoodsTag = goodsTag;
        NotifyUrl = notifyUrl;
        TradeType = tradeType;
        ProductId = productId;
        LimitPay = limitPay ? "no_credit" : null;
        OpenId = openid;
        Key = key;
        SubAppId = subappid;
        SubMchId = submchid;
        SubOpenid = subOpenid;
        SceneInfo = sceneInfo;

        //创建支付应答对象
        PackageRequestHandler = new RequestHandler();
        //初始化
        PackageRequestHandler.init();

        //设置package订单参数
        //以下设置顺序按照官方文档排序，方便维护：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
        PackageRequestHandler.setParameter("appid", this.AppId);                       //公众账号ID
        PackageRequestHandler.setParameter("mch_id", this.MchId);                      //商户号
        PackageRequestHandler.setParameterWhenNotNull("sub_appid", this.SubAppId);     //子商户公众账号ID
        PackageRequestHandler.setParameterWhenNotNull("sub_mch_id", this.SubMchId);    //子商户号
        PackageRequestHandler.setParameterWhenNotNull("device_info", this.DeviceInfo); //自定义参数
        PackageRequestHandler.setParameter("nonce_str", this.NonceStr);                //随机字符串
        PackageRequestHandler.setParameterWhenNotNull("sign_type", this.SignType);     //签名类型，默认为MD5
        PackageRequestHandler.setParameter("body", this.Body);                         //商品信息
        PackageRequestHandler.setParameterWhenNotNull("detail", this.Detail);          //商品详细列表
        PackageRequestHandler.setParameterWhenNotNull("attach", this.Attach);          //附加数据
        PackageRequestHandler.setParameter("out_trade_no", this.OutTradeNo);           //商家订单号
        PackageRequestHandler.setParameterWhenNotNull("fee_type", this.FeeType);       //符合ISO 4217标准的三位字母代码，默认人民币：CNY
        PackageRequestHandler.setParameter("total_fee", this.TotalFee + "");     //商品金额,以分为单位(money * 100).ToString()
        PackageRequestHandler.setParameter("spbill_create_ip", this.SpbillCreateIP);   //用户的公网ip，不是商户服务器IP
        PackageRequestHandler.setParameterWhenNotNull("time_start", this.TimeStart);   //订单生成时间
        PackageRequestHandler.setParameterWhenNotNull("time_expire", this.TimeExpire);  //订单失效时间
        PackageRequestHandler.setParameterWhenNotNull("goods_tag", this.GoodsTag);     //商品标记
        PackageRequestHandler.setParameter("notify_url", this.NotifyUrl);              //接收财付通通知的URL
        PackageRequestHandler.setParameter("trade_type", this.TradeType + "");   //交易类型
        PackageRequestHandler.setParameterWhenNotNull("product_id", this.ProductId);   //trade_type=NATIVE时（即扫码支付），此参数必传。
        PackageRequestHandler.setParameterWhenNotNull("limit_pay", this.LimitPay);     //上传此参数no_credit--可限制用户不能使用信用卡支付
        PackageRequestHandler.setParameterWhenNotNull("openid", this.OpenId);                     //用户的openId，trade_type=JSAPI时（即公众号支付），此参数必传
        PackageRequestHandler.setParameterWhenNotNull("sub_openid", this.SubOpenid);              //用户子标识
        if (SceneInfo != null) {
            PackageRequestHandler.setParameter("scene_info", SceneInfo + "");   //场景信息
        }

        Sign = PackageRequestHandler.createMd5Sign("key", this.Key);

        PackageRequestHandler.setParameter("sign", Sign);                              //签名
    }

    /**
     * @Author:Jrss
     * @Desp:服务商
     */
    public TenPayUnifiedorderRequestData(
            String appId, String mchId, String subappid, String submchid, String body, String outTradeNo, int totalFee, String spbillCreateIp,
            String notifyUrl, TenPayType tradeType, String openid, String subOpenid, String key, String nonceStr,
            String deviceInfo, Calendar timeStart, Calendar timeExpire,
            String detail, String attach, String feeType, String goodsTag,
            String productId, boolean limitPay,
            TenPayUnifiedorderRequestDataSceneInfo sceneInfo
    ) {
        initParameter(appId, mchId, subappid, submchid, body, outTradeNo, totalFee, spbillCreateIp,
                notifyUrl, tradeType, openid, subOpenid, key, nonceStr,
                deviceInfo, timeStart, timeExpire,
                detail, attach, feeType, goodsTag,
                productId, limitPay,
                sceneInfo);
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
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

    public String getDeviceInfo() {
        return DeviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        DeviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(String nonceStr) {
        NonceStr = nonceStr;
    }

    public String getSignType() {
        return SignType;
    }

    public void setSignType(String signType) {
        SignType = signType;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getAttach() {
        return Attach;
    }

    public void setAttach(String attach) {
        Attach = attach;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public String getOutTradeNo() {
        return OutTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        OutTradeNo = outTradeNo;
    }

    public int getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(int totalFee) {
        TotalFee = totalFee;
    }

    public String getSpbillCreateIP() {
        return SpbillCreateIP;
    }

    public void setSpbillCreateIP(String spbillCreateIP) {
        SpbillCreateIP = spbillCreateIP;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
    }

    public String getTimeExpire() {
        return TimeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        TimeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return GoodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        GoodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return NotifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        NotifyUrl = notifyUrl;
    }

    public TenPayType getTradeType() {
        return TradeType;
    }

    public void setTradeType(TenPayType tradeType) {
        TradeType = tradeType;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getLimitPay() {
        return LimitPay;
    }

    public void setLimitPay(String limitPay) {
        LimitPay = limitPay;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public TenPayUnifiedorderRequestDataSceneInfo getSceneInfo() {
        return SceneInfo;
    }

    public void setSceneInfo(TenPayUnifiedorderRequestDataSceneInfo sceneInfo) {
        SceneInfo = sceneInfo;
    }

    public String getSubOpenid() {
        return SubOpenid;
    }

    public void setSubOpenid(String subOpenid) {
        SubOpenid = subOpenid;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public RequestHandler getPackageRequestHandler() {
        return PackageRequestHandler;
    }

    public void setPackageRequestHandler(RequestHandler packageRequestHandler) {
        PackageRequestHandler = packageRequestHandler;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }
}
