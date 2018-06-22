package mp.tenPay.tenPayApi;

import mp.emums.TenPayType;
import mp.tenPay.RequestHandler;
import mp.tenPay.entities.request.*;
import mp.tenPay.entities.request.payBank.TenPayPayBankRequestData;
import mp.tenPay.entities.request.payBank.TenPayQueryBankRequestData;
import mp.tenPay.entities.result.*;
import mp.tenPay.entities.result.payBank.GetPublicKeyResult;
import mp.tenPay.entities.result.payBank.PayBankResult;
import mp.tenPay.entities.result.payBank.QueryBankResult;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;
import sun.util.resources.cldr.nus.CalendarData_nus_SD;
import weixin.GlobalConf;
import weixin.utilities.httpUtility.RequestUtility;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Timestamp;

/**
 * @Author:Jrss
 * @Desp:微信支付接口，官方API：https://mp.weixin.qq.com/paymch/readtemplate?t=mp/business/course2_tmpl&lang=zh_CN&token=25857919#4
 * @Date:Create in 13:59 2018/6/21
 * @Modified By:
 */
public class TenPay {
    /**
     * @Author:Jrss
     * @Desp:返回可用的微信支付地址（自动判断是否使用沙箱）
     */
    private static String reurnPayApiUrl(String urlFormat) {
        return String.format(urlFormat, GlobalConf.isUseSandBoxPay() ? "sandboxnew/" : "");
    }

    /**
     * @Author:Jrss
     * @Desp:带证书提交
     */
    private static String certPost(String cert, String certPassword, String data, String url, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String password = certPassword;
        String responseContent = "";

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");

            FileInputStream instream = new FileInputStream(new File(cert));

            keyStore.load(instream, certPassword.toCharArray());

            instream.close();

            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, certPassword.toCharArray()).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,

                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            responseContent = RequestUtility.httpPost(
                    url,
                    data,
                    null,
                    sslsf,
                    timeOut);
            return responseContent;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseContent;
    }

    /**
     * @Author:Jrss
     * @Desp:获取验签秘钥API
     */
    public static TenpayGetSignKeyResult getSignKey(TenPayGetSignKeyRequestData dataInfo, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String url = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML

        String resultXml = RequestUtility.httpPost(url, data, null, null, timeOut);
        return new TenpayGetSignKeyResult(resultXml);
    }


    /**
     * @Author:Jrss
     * @Desp:统一支付接口 * 统一支付接口，可接受JSAPI/NATIVE/APP 下预支付订单，返回预支付订单号。NATIVE 支付返回二维码code_url。
     */
    public static UnifiedorderResult unifiedorder(TenPayUnifiedorderRequestData dataInfo, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/unifiedorder");
        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, timeOut);
        return new UnifiedorderResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:H5支付接口（和“统一支付接口”近似）
     */
    public static UnifiedorderResult html5Order(TenPayUnifiedorderRequestData dataInfo, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }

        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/unifiedorder");
        dataInfo.setTradeType(TenPayType.MWEB);

        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, timeOut);
        return new UnifiedorderResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:获取UI使用的JS支付签名
     */
    public static String getJsPaySign(String appId, String timeStamp, String nonceStr, String packages, String key,
                                      String signType) {
        if (signType == null || signType.equalsIgnoreCase("")) {
            signType = "MD5";
        }
        //设置支付参数
        RequestHandler paySignReqHandler = new RequestHandler();
        paySignReqHandler.setParameter("appId", appId);
        paySignReqHandler.setParameter("timeStamp", timeStamp);
        paySignReqHandler.setParameter("nonceStr", nonceStr);
        paySignReqHandler.setParameter("package", packages);
        paySignReqHandler.setParameter("signType", signType);
        String paySign = paySignReqHandler.createMd5Sign("key", key);
        return paySign;
    }

    /**
     * @Author:Jrss
     * @Desp:Native
     */
    public static String nativePay(String appId, String timesTamp, String mchId, String nonceStr, String productId, String sign) {
        String urlFormat = "weixin://wxpay/bizpayurl?sign=%s&appid=%s&mch_id=%s&product_id=%s&time_stamp=%s&nonce_str=%s";
        String url = String.format(urlFormat, sign, appId, mchId, productId, timesTamp, nonceStr);

        return url;
    }

    /**
     * @Author:Jrss
     * @Desp:订单查询接口
     */
    public static OrderQueryResult orderQuery(TenPayOrderQueryRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/orderquery");
        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new OrderQueryResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:关闭订单接口
     */
    public static CloseOrderResult closeOrder(TenPayCloseOrderRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/closeorder");

        String data = dataInfo.getPackageRequestHandler().parseXML();
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new CloseOrderResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:撤销订单接口
     */
    public static ReverseResult reverse(TenPayReverseRequestData dataInfo, String cert, String certPassword, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%ssecapi/pay/reverse");
        String data = dataInfo.getPackageRequestHandler().parseXML();

        String responseContent = certPost(cert, certPassword, data, urlFormat, timeOut);
        return new ReverseResult(responseContent);
    }

    /**
     * @Author:Jrss
     * @Desp:退款申请接口
     */
    public static RefundResult refund(TenPayRefundRequestData dataInfo, String cert, String certPassword, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        //退款结果通知：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_16&index=11

        //退款接口地址
        String url = reurnPayApiUrl("https://api.mch.weixin.qq.com/%ssecapi/pay/refund");

        //本地或者服务器的证书位置（证书在微信支付申请成功发来的通知邮件中）
        //string cert = cert;// @"F:\apiclient_cert.p12";
        //私钥（在安装证书时设置）

        String data = dataInfo.getPackageRequestHandler().parseXML();
        String responseContent = certPost(cert, certPassword, data, url, timeOut);
        return new RefundResult(responseContent);
    }

    /**
     * @Author:Jrss
     * @Desp:退款查询接口
     */
    public static RefundQueryResult refundQuery(TenPayRefundQueryRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/refundquery");

        String data = dataInfo.getPackageRequestHandler().parseXML();
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new RefundQueryResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:对账单接口
     */
    public static String downloadBill(TenPayDownloadBillRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%spay/downloadbill");
        String data = dataInfo.getPackageRequestHandler().parseXML();
        return RequestUtility.httpPost(urlFormat, data, null, null, 0);
    }

    /**
     * @Author:Jrss
     * @Desp:短链接转换接口
     */
    public static ShortUrlResult shortUrl(TenPayShortUrlRequestData dataInfo) {
        String urlFormat = "https://api.mch.weixin.qq.com/tools/shorturl";
        String data = dataInfo.getPackageRequestHandler().parseXML();
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new ShortUrlResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:用于企业向微信用户个人付款,目前支持向指定微信用户的openid付款
     */
    public static TransfersResult transfers(TenPayTransfersRequestData dataInfo, String cert, String certPassword, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String url = reurnPayApiUrl("https://api.mch.weixin.qq.com/%smmpaymkttransfers/promotion/transfers");
        String data = dataInfo.getPackageRequestHandler().parseXML();
        String responseContent = certPost(cert, certPassword, data, url, 0);
        return new TransfersResult(responseContent);
    }

    /**
     * @Author:Jrss
     * @Desp:用于商户的企业付款操作进行结果查询，返回付款操作详细结果。【请求需要双向证书】
     */
    public static GetTransferInfoResult GetTransferInfo(TenPayGetTransferInfoRequestData dataInfo, String cert, String certPassword, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%smmpaymkttransfers/gettransferinfo");
        String data = dataInfo.getPackageRequestHandler().parseXML();
        String responseContent = certPost(cert, certPassword, data, urlFormat, timeOut);
        return new GetTransferInfoResult(responseContent);
    }

    /**
     * @Author:Jrss
     * @Desp:刷卡支付,提交被扫支付
     */
    public static MicropayResult MicroPay(TenPayMicroPayRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/{0}pay/micropay");

        String data = dataInfo.getPackageRequestHandler().parseXML();
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new MicropayResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp: <para>企业付款到银行卡</para>
     * <para>用于企业向微信用户银行卡付款,目前支持接口API的方式向指定微信用户的银行卡付款。</para>
     * <para>注意：请求需要双向证书</para>
     */
    public static PayBankResult PayBank(TenPayPayBankRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%smmpaysptrans/pay_bank");

        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new PayBankResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp: para>查询企业付款银行卡</para>
     * <para>注意：请求需要双向证书</para>
     */
    public static QueryBankResult QueryBank(TenPayQueryBankRequestData dataInfo) {
        String urlFormat = reurnPayApiUrl("https://api.mch.weixin.qq.com/%smmpaysptrans/query_bank");

        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new QueryBankResult(resultXml);
    }

    /**
     * @Author:Jrss
     * @Desp:<para>获取 RSA 加密公钥接口</para>
     * <para>https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7&index=4</para>
     */
    public static GetPublicKeyResult GetPublicKey(TenPayQueryBankRequestData dataInfo) {
        //TODO：官方文档没有明确此接口是否支持沙箱
        String urlFormat = reurnPayApiUrl("https://fraud.mch.weixin.qq.com/%srisk/getpublickey");

        String data = dataInfo.getPackageRequestHandler().parseXML();//获取XML
        String resultXml = RequestUtility.httpPost(urlFormat, data, null, null, 0);
        return new GetPublicKeyResult(resultXml);
    }
}
