package mp.advancedAPIs.templateMessage.templateMessageJson.templeteModel;

/**
 * @Author:Jrss
 * @Desp: 普通模板消息参数
 * @Date:Create in 16:17 2018/6/22
 * @Modified By:
 */
public class TempleteModel {

    /// 目标用户OpenId
    private String touser;

    /// 模板ID
    private String template_id;

    /// 模板消息顶部颜色（16进制），默认为#FF0000
    private String topcolor;

    /// 模板跳转链接
    private String url;

    /// 跳小程序所需数据，不需跳小程序可不用传该数据
    public TempleteModelMiniProgram miniprogram;

    /// 数据
    public Object data;

    public TempleteModel() {
        topcolor = "#FF0000";
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TempleteModelMiniProgram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(TempleteModelMiniProgram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
