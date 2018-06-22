package mp.advancedAPIs.templateMessage;

import mp.advancedAPIs.templateMessage.templateMessageJson.AddtemplateJsonResult;
import mp.advancedAPIs.templateMessage.templateMessageJson.GetIndustryJsonResult;
import mp.advancedAPIs.templateMessage.templateMessageJson.GetPrivateTemplateJsonResult;
import mp.advancedAPIs.templateMessage.templateMessageJson.SendTemplateMessageResult;
import mp.advancedAPIs.templateMessage.templateMessageJson.templeteModel.SubscribeMsgTempleteModel;
import mp.advancedAPIs.templateMessage.templateMessageJson.templeteModel.TempleteModel;
import mp.commonAPIs.ApiHandlerWapper;
import mp.commonAPIs.CommonJsonSend;
import mp.emums.IndustryCode;
import weixin.entities.jsonResult.WxJsonResult;
import weixin.enums.CommonJsonSendType;

/**
 * @Author:Jrss
 * @Desp:模板消息接口
 * @Date:Create in 16:16 2018/6/22
 * @Modified By:
 */
public class TemplateApi {

    /**
     * @Author:Jrss
     * @Desp:获取URL：一次性订阅消息，第一步引导用户打开链接进行授权,文档地址：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1500374289_66bvB
     */
    public static String getSubscribeMsgUrl(String appId, int scene, String templateId, String redirectUrl, String reserved, String action) {
        if (action == null || action.equalsIgnoreCase("")) {
            action = "get_confirm";
        }
        //无论直接打开还是做页面302重定向时，必须带#wechat_redirect参数
        return String.format("https://mp.weixin.qq.com/mp/subscribemsg?action=%s&appid=%s&scene=%s&template_id=%s&redirect_url=%s&reserved=%s#wechat_redirect",
                action, appId, scene, templateId, redirectUrl, reserved);
    }

    /**
    *@Author:Jrss
    *@Desp:模板消息接口
    */
    public static SendTemplateMessageResult SendTemplateMessage(string accessTokenOrAppId, string openId, string templateId, string url, object data, TempleteModel_MiniProgram miniProgram = null, int timeOut = Config.TIME_OUT)
    {
        //文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1500374289_66bvB

        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/message/template/send?access_token={0}";
        String msgData = new TempleteModel()
        {
            touser = openId,
            template_id = templateId,
            // topcolor = topcolor,
            url = url,
            miniprogram = miniProgram,
            data = data,
        };
        return CommonJsonSend.send(accessToken, urlFormat, msgData, timeOut);

            }, accessTokenOrAppId);
    }

    /// <summary>
    /// 模板消息接口
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="openId"></param>
    /// <param name="templateMessageData"></param>
    /// <param name="miniProgram">跳小程序所需数据，不需跳小程序可不用传该数据</param>
    /// <param name="timeOut">代理请求超时时间（毫秒）</param>
    /// <returns></returns>
    public static SendTemplateMessageResult SendTemplateMessage(string accessTokenOrAppId, string openId, ITemplateMessageBase templateMessageData, TempleteModel_MiniProgram miniProgram = null, int timeOut = Config.TIME_OUT)
    {
        return SendTemplateMessage(accessTokenOrAppId, openId, templateMessageData.TemplateId,
                templateMessageData.Url, templateMessageData, miniProgram, timeOut);
    }

    /// <summary>
    /// 设置所属行业
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="industry_id1">公众号模板消息所属行业编号</param>
    /// <param name="industry_id2">公众号模板消息所属行业编号</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>
    public static WxJsonResult SetIndustry(string accessTokenOrAppId, IndustryCode industry_id1, IndustryCode industry_id2, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/template/api_set_industry?access_token={0}";
        var msgData = new
        {
            industry_id1 = ((int)industry_id1).ToString(),
                    industry_id2 = ((int)industry_id2).ToString()
        };
        return CommonJsonSend.Send<WxJsonResult>(accessToken, urlFormat, msgData, timeOut: timeOut);

            }, accessTokenOrAppId);
    }

    /// <summary>
    /// 获取设置的行业信息
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>
    public static GetIndustryJsonResult GetIndustry(string accessTokenOrAppId, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/template/get_industry?access_token={0}";
        return CommonJsonSend.Send<GetIndustryJsonResult>(accessToken, urlFormat, null, CommonJsonSendType.GET, timeOut: timeOut);

            }, accessTokenOrAppId);
    }
    /// <summary>
    /// 添加模板并获得模板ID
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="template_id_short">模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>
    public static AddtemplateJsonResult Addtemplate(string accessTokenOrAppId, string template_id_short, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/template/api_add_template?access_token={0}";
        var msgData = new
        {
            template_id_short = template_id_short

        };
        return CommonJsonSend.Send<AddtemplateJsonResult>(accessToken, urlFormat, msgData, CommonJsonSendType.POST, timeOut: timeOut);

            }, accessTokenOrAppId);
    }
    /// <summary>
    /// 获取模板列表
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>

    public static GetPrivateTemplateJsonResult GetPrivateTemplate(string accessTokenOrAppId, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/template/get_all_private_template?access_token={0}";
        return CommonJsonSend.Send<GetPrivateTemplateJsonResult>(accessToken, urlFormat, null, CommonJsonSendType.GET, timeOut: timeOut);

            }, accessTokenOrAppId);
    }
    /// <summary>
    /// 删除模板
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="template_id">公众帐号下模板消息ID</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>
    public static WxJsonResult DelPrivateTemplate(string accessTokenOrAppId, string template_id, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/template/del_private_template?access_token={0}";
        var msgData = new
        {
            template_id = template_id
        };

        return CommonJsonSend.Send<WxJsonResult>(accessToken, urlFormat, msgData, CommonJsonSendType.POST, timeOut: timeOut);

            }, accessTokenOrAppId);
    }

    /// <summary>
    /// 通过API推送订阅模板消息给到授权微信用户
    /// </summary>
    /// <param name="accessTokenOrAppId">AccessToken或AppId（推荐使用AppId，需要先注册）</param>
    /// <param name="toUserOpenId">填接收消息的用户openid</param>
    /// <param name="templateId">订阅消息模板ID</param>
    /// <param name="scene">订阅场景值</param>
    /// <param name="title">消息标题，15字以内</param>
    /// <param name="data">消息正文，value为消息内容，color为颜色，200字以内</param>
    /// <param name="url">点击消息跳转的链接，需要有ICP备案</param>
    /// <param name="timeOut"></param>
    /// <returns></returns>
    public static WxJsonResult Subscribe(string accessTokenOrAppId, string toUserOpenId, string templateId, string scene, string title, object data, string url = null, int timeOut = Config.TIME_OUT)
    {
        return ApiHandlerWapper.TryCommonApi(accessToken =>
                {
                        string urlFormat = Config.ApiMpHost + "/cgi-bin/message/template/subscribe?access_token={0}";

        var msgData = new SubscribeMsgTempleteModel()
        {
            touser = toUserOpenId,
            template_id = templateId,
            url = url,
            scene = scene,
            title = title,
            data = data
        };

        return CommonJsonSend.Send<WxJsonResult>(accessToken, urlFormat, msgData, CommonJsonSendType.POST, timeOut: timeOut);

            }, accessTokenOrAppId);
    }
}
