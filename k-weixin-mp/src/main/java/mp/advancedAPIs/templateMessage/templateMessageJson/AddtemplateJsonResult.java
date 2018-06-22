package mp.advancedAPIs.templateMessage.templateMessageJson;

import weixin.entities.jsonResult.WxJsonResult;

/**
 * @Author:Jrss
 * @Desp:AddtemplateJsonResult
 * @Date:Create in 16:21 2018/6/22
 * @Modified By:
 */
public class AddtemplateJsonResult extends WxJsonResult {

    private  String template_id;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
}
