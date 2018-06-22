package mp.advancedAPIs.templateMessage.templateMessageJson;

import mp.emums.IndustryCode;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 16:25 2018/6/22
 * @Modified By:
 */
public class GetIndustryItem {
    /// <summary>
    /// 主行业
    /// </summary>
    private String first_class;
    /// <summary>
    /// 副行业
    /// </summary>
    private String second_class;

    /**
     * @Author:Jrss
     * @Desp:将当前对象转成IndustryCode
     */
    public IndustryCode ConvertToIndustryCode() {
        String enumName = String.format("%s_%s", first_class,
                second_class.replace("|", "_").replace("/", "_"));

        IndustryCode code;
        try {
            code = (IndustryCode) Enum.valueOf(IndustryCode.class, enumName);
        } catch (Exception e) {
            e.printStackTrace();
            return IndustryCode.其它_其它;//没有成功，此处也可以抛出异常
        }
        return code;
    }

    public String getFirst_class() {
        return first_class;
    }

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getSecond_class() {
        return second_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }
}
