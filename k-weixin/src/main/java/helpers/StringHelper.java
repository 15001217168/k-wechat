package helpers;

import com.sun.jndi.toolkit.url.UrlUtil;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:Jrss
 * @Desp:字符串帮助类
 * @Date:Create in 15:38 2018/6/20
 * @Modified By:
 */
public class StringHelper {

    public static String getUrlData(String input) {
        return URLEncoder.encode(input, "utf-8");
    }
}
