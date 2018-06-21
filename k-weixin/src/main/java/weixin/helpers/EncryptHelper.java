package weixin.helpers;

import sun.misc.BASE64Encoder;
import weixin.enums.ReturnCode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:Jrss
 * @Desp:安全帮助类，提供SHA-1算法等
 * @Date:Create in 15:38 2018/6/20
 * @Modified By:
 */
public class EncryptHelper {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    /**
     * @Author:Jrss
     * @Desp:采用SHA-1算法加密字符串（小写）
     */
    public static String GetSha1(String encypStr) {
        if (encypStr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(encypStr.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Author:Jrss
     * @Desp:HMAC SHA256 加密
     */
    public static String GetHmacSha256(String message, String secret) {
        byte[] key = secret.getBytes();
        byte[] data = message.getBytes();
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author:Jrss
     * @Desp:获取大写的MD5签名结果
     */
    public static String GetMD5(String encypStr) {
        //确定计算方法
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();

            //加密后的字符串
            String newstr = base64en.encode(md5.digest(encypStr.getBytes()));
            return newstr.toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Author:Jrss
     * @Desp:获取小写的MD5签名结果
     */
    public static String GetLowerMD5(String encypStr) {
        return GetMD5(encypStr).toLowerCase();
    }

    public static String AESDecrypt(String base64Encode, String md5Str) {
        return  "";
    }
}
