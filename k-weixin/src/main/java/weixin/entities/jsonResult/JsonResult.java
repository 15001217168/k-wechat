package weixin.entities.jsonResult;

/**
 * @Author:Jrss
 * @Desp:所有JSON返回结果基类
 * @Date:Create in 18:57 2018/6/20
 * @Modified By:
 */
public class JsonResult {
    private  String errmsg;
    private  int ErrorCodeValue;
    private  Object P2PData;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrorCodeValue() {
        return ErrorCodeValue;
    }

    public void setErrorCodeValue(int errorCodeValue) {
        ErrorCodeValue = errorCodeValue;
    }

    public Object getP2PData() {
        return P2PData;
    }

    public void setP2PData(Object p2PData) {
        P2PData = p2PData;
    }
}
