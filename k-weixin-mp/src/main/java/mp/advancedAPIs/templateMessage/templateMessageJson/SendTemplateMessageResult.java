package mp.advancedAPIs.templateMessage.templateMessageJson;

import weixin.entities.jsonResult.WxJsonResult;

/**
 * @Author:Jrss
 * @Desp:发送模板消息结果
 * @Date:Create in 16:42 2018/6/22
 * @Modified By:
 */
public class SendTemplateMessageResult extends WxJsonResult {
    /// msgid
    private long msgid;

    public long getMsgid() {
        return msgid;
    }

    public void setMsgid(long msgid) {
        this.msgid = msgid;
    }
}
