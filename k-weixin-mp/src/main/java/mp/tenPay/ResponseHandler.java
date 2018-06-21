package mp.tenPay;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import weixin.helpers.EncryptHelper;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 13:49 2018/6/21
 * @Modified By:
 */
public class ResponseHandler {
    /// 密钥
    private String Key;

    /// appkey
    private String Appkey;

    /// 应答的参数
    protected Hashtable Parameters;

    /// debug信息
    private String DebugInfo;
    /// 原始内容
    protected String Content;

    private String Charset = "gb2312";

    /**
     * @Author:Jrss
     * @Desp:初始化函数
     */
    public void Init() {
    }

    public ResponseHandler() {
        Parameters = new Hashtable();

    }

    /**
     * @Author:Jrss
     * @Desp:设置参数值
     */
    public void setParameter(String parameter, String parameterValue) {

        if (parameter != null && parameter != "") {
            if (Parameters.containsKey(parameter)) {
                Parameters.remove(parameter);
            }
            Parameters.put(parameter, parameterValue);
        }
    }

    /**
     * @Author:Jrss
     * @Desp:获取参数值
     */
    public String getParameter(String parameter) {
        String s = (String) Parameters.get(parameter);
        return (null == s) ? "" : s;
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
        Enumeration<String> e = Parameters.keys();
        while (e.hasMoreElements()) {
            akeys.add(e.nextElement());
        }
        Collections.sort(akeys);
        return akeys;
    }
    /**
     * @Author:Jrss
     * @Desp:是否财付通签名,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。return boolean
     */
    public Boolean isTenpaySign() {
        StringBuilder sb = new StringBuilder();
        List<String> akeys = getKeys();
        for (String k : akeys) {
            String v = (String) Parameters.get(k);
            if (null != v && "".equalsIgnoreCase(v)
                    && "sign".equalsIgnoreCase(k) && "key".equalsIgnoreCase(k)) {
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + this.getKey());
        String sign = EncryptHelper.GetMD5(sb.toString()).toLowerCase();
        this.setDebugInfo(sb.toString() + " &sign=" + sign);
        //debug信息
        return getParameter("sign").toLowerCase().equals(sign);
    }

    /**
     * @Author:Jrss
     * @Desp:输出XML
     */
    public String parseXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        List<String> akeys = new ArrayList<String>();
        Enumeration<String> e = Parameters.keys();
        while (e.hasMoreElements()) {
            akeys.add(e.nextElement());
        }
        for (String k : akeys) {
            String v = (String) Parameters.get(k);
            if (Pattern.matches("^[0-9.]$", v)) {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            } else {
                sb.append("<" + k + "><![CDATA[" + v + "]]></" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getAppkey() {
        return Appkey;
    }

    public void setAppkey(String appkey) {
        Appkey = appkey;
    }

    public Hashtable getParameters() {
        return Parameters;
    }

    public void setParameters(Hashtable parameters) {
        Parameters = parameters;
    }

    public String getDebugInfo() {
        return DebugInfo;
    }

    public void setDebugInfo(String debugInfo) {
        DebugInfo = debugInfo;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }
}
