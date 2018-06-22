package mp.advancedAPIs.templateMessage.templateMessageJson;

import weixin.entities.jsonResult.WxJsonResult;

/**
 * @Author:Jrss
 * @Desp:GetIndustryJsonResult
 * @Date:Create in 16:25 2018/6/22
 * @Modified By:
 */
public class GetIndustryJsonResult extends WxJsonResult {

    /// 帐号设置的主营行业
    private  GetIndustryItem primary_industry;

    /// 帐号设置的副营行业
    private GetIndustryItem secondary_industry;

    public GetIndustryItem getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(GetIndustryItem primary_industry) {
        this.primary_industry = primary_industry;
    }

    public GetIndustryItem getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(GetIndustryItem secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}
