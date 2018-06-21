package mp.emums;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 15:06 2018/6/20
 * @Modified By:
 */
public enum EnumsResponseMsgType {
    Text,//文本
    News,//单图文
    Music,//音乐
    Image,//图片
    Voice,//语音
    Video,//视频
    Transfer_Customer_Service,//多客服
    //以下为延伸类型，微信官方并未提供具体的回复类型
    MultipleNews,//多图文
    LocationMessage,//位置
    NoResponse,//无回复
    SuccessResponse //success
}


