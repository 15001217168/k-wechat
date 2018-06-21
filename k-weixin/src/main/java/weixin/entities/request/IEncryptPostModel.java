package weixin.entities.request;

import java.util.Set;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 15:14 2018/6/20
 * @Modified By:
 */
public interface IEncryptPostModel {

    public abstract String getSignature();

    public abstract void setSignature();

    public abstract String getMsg_Signature();

    public abstract void setMsg_Signature();


    public abstract String getTimestamp();

    public abstract void setTimestamp();


    public abstract String getNonce();

    public abstract void setNonce();

    public abstract String getToken();

    public abstract void setToken();

    public abstract String getEncodingAESKey();

    public abstract void setEncodingAESKey();
}
