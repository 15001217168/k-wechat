package mp.tenPay.tenPayApi.redPackApi;
import mp.tenPay.TenPayUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author:Jrss
 * @Desp: 红包发送和查询Api（暂缺裂变红包发送）
 * @Date:Create in 16:06 2018/6/22
 * @Modified By:
 */
public class RedPackApi {
    private static String getNewBillNo(String mchId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssfff");
        return String.format("%s%s", format.format(Calendar.getInstance().getTime()), TenPayUtil.BuildRandomStr(3));
    }
}