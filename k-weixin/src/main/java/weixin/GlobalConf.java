package weixin;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * @Author:Jrss
 * @Desp:全局设置
 * @Date:Create in 18:47 2018/6/20
 * @Modified By:
 */
public class GlobalConf {

    public final static String ApiMpHost = "https://api.weixin.qq.com";
    public final static int TimeOut = 10000;

    private static boolean useSandBoxPay;

    public static boolean isUseSandBoxPay() {
        return useSandBoxPay;
    }

    public static void setUseSandBoxPay(boolean useSandBoxPay) {
        GlobalConf.useSandBoxPay = useSandBoxPay;
    }
}
