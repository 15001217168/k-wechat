package mp.tenPay;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import weixin.helpers.EncryptHelper;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author:Jrss
 * @Desp:签名工具类
 * @Date:Create in 13:49 2018/6/21
 * @Modified By:
 */
public class RequestHandler {
    private String key;
    protected Hashtable parameters;
    private String debugInfo;


    public RequestHandler() {
    }

    /**
     * @Author:Jrss
     * @Desp:初始化函数
     */
    public void init() {
    }

    /**
     * @Author:Jrss
     * @Desp:设置参数值
     */
    public void setParameter(String parameter, String parameterValue) {

        if (parameter != null && parameter != "") {
            if (parameters.containsKey(parameter)) {
                parameters.remove(parameter);
            }
            parameters.put(parameter, parameterValue);
        }
    }

    /**
     * @Author:Jrss
     * @Desp:当参数不为null或空字符串时，设置参数值
     */
    public void setParameterWhenNotNull(String parameter, String parameterValue) {
        if (parameterValue != null && parameterValue.equalsIgnoreCase("")) {
            setParameter(parameter, parameterValue);
        }
    }

    private List<String> getKeys() {
        List<String> akeys = new ArrayList<String>();
        Enumeration<String> e = parameters.keys();
        while (e.hasMoreElements()) {
            akeys.add(e.nextElement());
        }
        Collections.sort(akeys);
        return akeys;
    }

    /**
     * @Author:Jrss
     * @Desp:创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名
     */
    public String createMd5Sign(String key, String value) {
        StringBuilder sb = new StringBuilder();

        List<String> akeys = getKeys();
        for (String k : akeys) {
            String v = (String) parameters.get(k);
            if (null != v && "".equalsIgnoreCase(v)
                    && "sign".equalsIgnoreCase(k)
                    && "key".equalsIgnoreCase(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append(key + "=" + value);

        //编码强制使用UTF8：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_1
        String sign = EncryptHelper.GetMD5(sb.toString()).toUpperCase();

        return sign;
    }

    /**
     * @Author:Jrss
     * @Desp:输出XML
     */
    public String parseXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        List<String> akeys = getKeys();
        for (String k : akeys) {
            String v = (String) parameters.get(k);
            if (v != null && Pattern.matches("^[0-9.]$", v)) {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            } else {
                sb.append("<" + k + "><![CDATA[" + v + "]]></" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Hashtable getParameters() {
        return parameters;
    }

    public void setParameters(Hashtable parameters) {
        this.parameters = parameters;
    }

    public String getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
    }
}
