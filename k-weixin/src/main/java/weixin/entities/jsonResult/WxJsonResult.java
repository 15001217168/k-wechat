package weixin.entities.jsonResult;

import weixin.enums.ReturnCode;

/**
 * @Author:Jrss
 * @Desp:公众号 JSON 返回结果（用于菜单接口等）
 * @Date:Create in 10:26 2018/6/21
 * @Modified By:
 */
public class WxJsonResult extends BaseJsonResult {

    private ReturnCode errcode;

    public ReturnCode getErrcode() {
        return errcode;
    }

    public void setErrcode(ReturnCode errcode) {
        this.errcode = errcode;
    }

}
