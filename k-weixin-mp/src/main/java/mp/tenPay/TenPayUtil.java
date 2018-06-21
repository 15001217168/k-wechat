package mp.tenPay;

import weixin.helpers.EncryptHelper;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 * @Author:Jrss
 * @Desp:微信支付工具类
 * @Date:Create in 15:05 2018/6/20
 * @Modified By:
 */
public class TenPayUtil {
    public static Random random = new Random();

    /**
     * @Author:Jrss
     * @Desp:随机生成Noncestr
     */
    public static String GetNoncestr() {
        String uuid = UUID.randomUUID().toString();
        return EncryptHelper.GetMD5(uuid);
    }

    /**
     * @Author:Jrss
     * @Desp:获取微信时间格式
     */
    public static String GetTimestamp() {
        return Calendar.getInstance().getTimeInMillis() + "";
    }

    /**
     * @Author:Jrss
     * @Desp:对字符串进行URL编码
     */
    public static String UrlEncode(String instr) {
        if (instr == null || instr.equalsIgnoreCase(""))
            return "";
        else {

        }
    }

    /**
     * @Author:Jrss
     * @Desp:对字符串进行URL解码
     */
    public static String UrlDecode(String instr) {
        if (instr == null || instr.equalsIgnoreCase(""))
            return "";
        else {
            return UrlDecode(instr);
        }
    }

    /**
     * @Author:Jrss
     * @Desp:取时间戳生成随即数,替换交易单号中的后10位流水号
     */
    public static long UnixStamp() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * @Author:Jrss
     * @Desp:取随机数
     */
    public static String BuildRandomStr(int length) {
        int num;
        num = random.nextInt();
        String str = num + "";

        if (str.length() > length) {
            str = str.substring(0, length);
        } else if (str.length() < length) {
            int n = length - str.length();
            while (n > 0) {
                str = "0" + str;
                n--;
            }
        }
        return str;
    }

    /**
     * @Author:Jrss
     * @Desp:创建当天内不会重复的数字
     */
    public static String BuildDailyRandomStr(int length) {
        Calendar calendar = Calendar.getInstance();
        String stringFormat = calendar.get(Calendar.HOUR) + "" + calendar.get(Calendar.MINUTE) + "" + calendar.get(Calendar.SECOND) + "0000";
        return stringFormat;
    }


    /**
     * @Author:Jrss
     * @Desp:对退款通知消息进行解密
     */
    public static String DecodeRefundReqInfo(String reqInfo, String mchKey) {
        //参考文档：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_16&index=11
            /*
               解密步骤如下：
                （1）对加密串A做base64解码，得到加密串B
                （2）对商户key做md5，得到32位小写key* ( key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置 )

                （3）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
             */
        String base64Encode = reqInfo;//(1) EncryptHelper.AESDecrypt 方法内部会进行一次base64解码，因此这里不再需要解码
        String md5Str = EncryptHelper.GetLowerMD5(mchKey);//(2)
        String result = EncryptHelper.AESDecrypt(base64Encode, md5Str);//(3)
        return result;
    }
}
