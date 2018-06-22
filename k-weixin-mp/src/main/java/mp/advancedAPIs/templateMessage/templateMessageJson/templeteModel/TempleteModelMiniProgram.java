package mp.advancedAPIs.templateMessage.templateMessageJson.templeteModel;

/**
 * @Author:Jrss
 * @Desp:小程序定义
 * @Date:Create in 16:18 2018/6/22
 * @Modified By:
 */
public class TempleteModelMiniProgram {

    /// 小程序AppId
    private String appid;

    /// 路径，如：index?foo=bar
    private String pagepath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
