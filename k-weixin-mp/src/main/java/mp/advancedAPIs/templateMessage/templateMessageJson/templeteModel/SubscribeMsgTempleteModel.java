package mp.advancedAPIs.templateMessage.templateMessageJson.templeteModel;

/**
 * @Author:Jrss
 * @Desp:一次性订阅消息模板
 * @Date:Create in 16:17 2018/6/22
 * @Modified By:
 */
public class SubscribeMsgTempleteModel extends TempleteModel {

    /// 消息标题，15字以内
    private String title;

    /// （必填）订阅场景值
    private String scene;

    public SubscribeMsgTempleteModel() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
}
