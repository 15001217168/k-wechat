package mp.tenPay.entities.result;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Jrss
 * @Desp:基础返回结果（微信支付返回结果基类）
 * @Date:Create in 16:30 2018/6/21
 * @Modified By:
 */
public class TenPayResult {
    private String return_code;
    private String return_msg;
    private Document resultXml;

    public TenPayResult(String xml) {
        try {
            resultXml = DocumentHelper.parseText(xml);
            return_code = getXmlValue("return_code"); // res.Element("xml").Element
            if (!isReturnCodeSuccess()) {
                return_msg = getXmlValue("return_msg"); // res.Element("xml").Element
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * @Author:Jrss
     * @Desp:获取Xml结果中对应节点的值
     */
    public String getXmlValue(String nodeName) {
        Element root = resultXml.getRootElement();
        if (resultXml == null || root == null
                || root.element(nodeName) == null) {
            return "";
        }
        return root.element(nodeName).getTextTrim();
    }

    /**
     * @Author:Jrss
     * @Desp:获取Xml结果中对应节点的集合值
     */
    public <T> List<T> getXmlValues(String nodeName,Class<T> type) {
        List<T> result = new ArrayList<T>();
        try {
            if (resultXml != null) {
                Element xElement = resultXml.getRootElement();
                if (xElement != null) {
                    List<Element> list = xElement.elements();
                    for (Element e : list) {
                        String name = e.getName();
                        if (name.startsWith(nodeName)) {
                            result.add((T) e.getTextTrim());
                        }
                    }
                }
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return result;
    }


    public boolean isReturnCodeSuccess() {
        return return_code == "SUCCESS";
    }


    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public Document getResultXml() {
        return resultXml;
    }

    public void setResultXml(Document resultXml) {
        this.resultXml = resultXml;
    }
}
