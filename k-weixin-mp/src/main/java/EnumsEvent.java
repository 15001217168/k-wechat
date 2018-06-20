/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 15:06 2018/6/20
 * @Modified By:
 */
public enum EnumsEvent {
    /// <summary>
    /// 进入会话（似乎已从官方API中移除）
    /// </summary>
    ENTER,

    /// <summary>
    /// 地理位置（似乎已从官方API中移除）
    /// </summary>
    LOCATION,

    /// <summary>
    /// 订阅
    /// </summary>
    subscribe,

    /// <summary>
    /// 取消订阅
    /// </summary>
    unsubscribe,

    /// <summary>
    /// 自定义菜单点击事件
    /// </summary>
    CLICK,

    /// <summary>
    /// 二维码扫描
    /// </summary>
    scan,

    /// <summary>
    /// URL跳转
    /// </summary>
    VIEW,

    /// <summary>
    /// 事件推送群发结果
    /// </summary>
    MASSSENDJOBFINISH,

    /// <summary>
    /// 模板信息发送完成
    /// </summary>
    TEMPLATESENDJOBFINISH,

    /// <summary>
    /// 扫码推事件
    /// </summary>
    scancode_push,

    /// <summary>
    /// 扫码推事件且弹出“消息接收中”提示框
    /// </summary>
    scancode_waitmsg,

    /// <summary>
    /// 弹出系统拍照发图
    /// </summary>
    pic_sysphoto,

    /// <summary>
    /// 弹出拍照或者相册发图
    /// </summary>
    pic_photo_or_album,

    /// <summary>
    /// 弹出微信相册发图器
    /// </summary>
    pic_weixin,

    /// <summary>
    /// 弹出地理位置选择器
    /// </summary>
    location_select,

    /// <summary>
    /// 卡券通过审核
    /// </summary>
    card_pass_check,

    /// <summary>
    /// 卡券未通过审核
    /// </summary>
    card_not_pass_check,

    /// <summary>
    /// 领取卡券
    /// </summary>
    user_get_card,

    /// <summary>
    /// 删除卡券
    /// </summary>
    user_del_card,

    /// <summary>
    /// 多客服接入会话
    /// </summary>
    kf_create_session,

    /// <summary>
    /// 多客服关闭会话
    /// </summary>
    kf_close_session,

    /// <summary>
    /// 多客服转接会话
    /// </summary>
    kf_switch_session,

    /// <summary>
    /// 审核结果事件推送
    /// </summary>
    poi_check_notify,

    /// <summary>
    /// Wi-Fi连网成功
    /// </summary>
    WifiConnected,

    /// <summary>
    /// 卡券核销
    /// </summary>
    user_consume_card,

    /// <summary>
    /// 进入会员卡
    /// </summary>
    user_view_card,

    /// <summary>
    /// 从卡券进入公众号会话
    /// </summary>
    user_enter_session_from_card,

    /// <summary>
    /// 微小店订单付款通知
    /// </summary>
    merchant_order,

    /// <summary>
    /// 接收会员信息事件通知
    /// </summary>
    submit_membercard_user_info,

    /// <summary>
    /// 摇一摇事件通知
    /// </summary>
    ShakearoundUserShake,
    /// <summary>
    /// 卡券转赠事件推送
    /// </summary>
    user_gifting_card,
    /// <summary>
    /// 微信买单完成
    /// </summary>
    user_pay_from_pay_cell,
    /// <summary>
    /// 会员卡内容更新事件：会员卡积分余额发生变动时
    /// </summary>
    update_member_card,
    /// <summary>
    /// 卡券库存报警事件：当某个card_id的初始库存数大于200且当前库存小于等于100时
    /// </summary>
    card_sku_remind,
    /// <summary>
    /// 券点流水详情事件：当商户朋友的券券点发生变动时
    /// </summary>
    card_pay_order,


    /// <summary>
    /// 资质认证成功（此时立即获得接口权限）
    /// </summary>
    qualification_verify_success,
    /// <summary>
    /// 名称认证成功（即命名成功）
    /// </summary>
    qualification_verify_fail,
    /// <summary>
    /// 名称认证成功（即命名成功）
    /// </summary>
    naming_verify_success,
    /// <summary>
    /// 名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
    /// </summary>
    naming_verify_fail,
    /// <summary>
    /// 年审通知
    /// </summary>
    annual_renew,
    /// <summary>
    /// 认证过期失效通知
    /// </summary>
    verify_expired,

    /// <summary>
    /// 小程序审核成功
    /// </summary>
    weapp_audit_success,
    /// <summary>
    /// 小程序审核失败
    /// </summary>
    weapp_audit_fail
}


