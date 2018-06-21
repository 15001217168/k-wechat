package mp.tenPay.tenPayApi;

import mp.tenPay.entities.request.TenPayGetSignKeyRequestData;
import mp.tenPay.entities.result.TenpayGetSignKeyResult;
import weixin.GlobalConf;

/**
 * @Author:Jrss
 * @Desp:微信支付接口，官方API：https://mp.weixin.qq.com/paymch/readtemplate?t=mp/business/course2_tmpl&lang=zh_CN&token=25857919#4
 * @Date:Create in 13:59 2018/6/21
 * @Modified By:
 */
public class TenPay {

    /**
     * @Author:Jrss
     * @Desp:获取验签秘钥API
     */
    public static TenpayGetSignKeyResult GetSignKey(TenPayGetSignKeyRequestData dataInfo, int timeOut) {
        if (timeOut == 0) {
            timeOut = GlobalConf.TimeOut;
        }
        String url = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

        String data = dataInfo.PackageRequestHandler.parseXML();//获取XML
        //throw new Exception(data.HtmlEncode());
//        MemoryStream ms = new MemoryStream();
//        var formDataBytes = data == null ? new byte[0] : Encoding.UTF8.GetBytes(data);
//        ms.Write(formDataBytes, 0, formDataBytes.Length);
//        ms.Seek(0, SeekOrigin.Begin);//设置指针读取位置

        String resultXml ="";// RequestUtility.HttpPost(url, null, ms, timeOut);
        return new TenpayGetSignKeyResult(resultXml);
    }
}
