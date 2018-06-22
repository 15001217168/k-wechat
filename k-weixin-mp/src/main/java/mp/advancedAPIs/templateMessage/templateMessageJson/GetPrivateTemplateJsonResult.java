package mp.advancedAPIs.templateMessage.templateMessageJson;

import weixin.entities.jsonResult.WxJsonResult;

import java.util.List;

/**
 * @Author:Jrss
 * @Desp:GetPrivateTemplateJsonResult
 * @Date:Create in 16:38 2018/6/22
 * @Modified By:
 */
public class GetPrivateTemplateJsonResult extends WxJsonResult {

    private List<GetPrivateTemplateTemplateItem> template_list;

    public List<GetPrivateTemplateTemplateItem> getTemplate_list() {
        return template_list;
    }

    public void setTemplate_list(List<GetPrivateTemplateTemplateItem> template_list) {
        this.template_list = template_list;
    }
}
