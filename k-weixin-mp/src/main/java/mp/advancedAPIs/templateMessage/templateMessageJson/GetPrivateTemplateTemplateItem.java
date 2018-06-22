package mp.advancedAPIs.templateMessage.templateMessageJson;

import mp.emums.IndustryCode;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 16:38 2018/6/22
 * @Modified By:
 */
public class GetPrivateTemplateTemplateItem {
    /// 模板ID
    private String template_id;

    /// 模板标题
    private String title;

    /// 模板所属行业的一级行业
    private String primary_industry;

    /// 模板所属行业的二级行业
    private String deputy_industry;

    /// 模板内容
    private String content;

    /// 模板示例
    private String example;

    public IndustryCode ConvertToIndustryCode() {
        String enumName = String.format("{0}_{1}", primary_industry,
                deputy_industry.replace("|", "_").replace("/", "_"));

        IndustryCode code;
        try {
            code = (IndustryCode) Enum.valueOf(IndustryCode.class, enumName);
        } catch (Exception e) {
            e.printStackTrace();
            return IndustryCode.其它_其它;//没有成功，此处也可以抛出异常
        }
        return code;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(String primary_industry) {
        this.primary_industry = primary_industry;
    }

    public String getDeputy_industry() {
        return deputy_industry;
    }

    public void setDeputy_industry(String deputy_industry) {
        this.deputy_industry = deputy_industry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
