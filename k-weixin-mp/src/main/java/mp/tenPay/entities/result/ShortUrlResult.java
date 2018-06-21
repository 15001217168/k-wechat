package mp.tenPay.entities.result;

/**
 * @Author:Jrss
 * @Desp:短链接转换接口
 * @Date:Create in 17:42 2018/6/21
 * @Modified By:
 */
public class ShortUrlResult extends Result {
    //转换后的URL
    private String short_url;

    public ShortUrlResult(String resultXml) {
        super(resultXml);
        if (super.isReturnCodeSuccess()) {
            short_url = getXmlValue("short_url");
        }
    }
}
