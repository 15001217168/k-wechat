package mp.Request;

import weixin.entities.request.EncryptPostModel;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 15:09 2018/6/20
 * @Modified By:
 */
public class PostModel extends EncryptPostModel {

    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @Author:Jrss
     * @Desp:设置服务器内部保密信息
     */

    public void setSecretInfo(String token, String encodingAESKey, String appId) {
        super.setSecretInfo(token, encodingAESKey);
        appId = appId;
    }
}
