package mp.advancedAPIs.templateMessage.templateMessageJson;

import java.security.PrivateKey;

/**
 * @Author:Jrss
 * @Desp:模板消息的数据项类型
 * @Date:Create in 16:43 2018/6/22
 * @Modified By:
 */
public class TemplateDataItem {

    /// 项目值
    private String value;

    /// 16进制颜色代码，如：#FF0000
    private String color;

    /// <summary>
    /// TemplateDataItem 构造函数
    /// </summary>
    /// <param name="v">value</param>
    /// <param name="c">color</param>
    public TemplateDataItem(String v, String c) {
        if (c == null || c.equalsIgnoreCase("")) {
            c = "#173177";
        }
        value = v;
        color = c;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
