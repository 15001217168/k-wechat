package mp;

import mp.entities.request.PostModel;

/**
 * @Author:Jrss
 * @Desp:签名验证类
 * @Date:Create in 15:06 2018/6/20
 * @Modified By:
 */
public class CheckSignature {

    public final String token = "weixin";

    /**
     * @Author:Jrss
     * @Desp:检查签名是否正确
     */
    public static boolean Check(String signature, PostModel postModel) {
        return Check(signature, postModel.getTimestamp(), postModel.getNonce(), postModel.getToken());
    }

    /**
     * @Author:Jrss
     * @Desp:检查签名是否正确
     */
    public static boolean Check(String signature, String timestamp, String nonce, String token) {
        return signature == GetSignature(timestamp, nonce, token);
    }

    /**
     * @Author:Jrss
     * @Desp:返回正确的签名
     */
    public static String GetSignature(PostModel postModel) {
        return GetSignature(postModel.getTimestamp(), postModel.getNonce(), postModel.getToken());
    }

    /**
     * @Author:Jrss
     * @Desp:返回正确的签名
     */
    public static String GetSignature(String timestamp, String nonce, String token) {
        return "";
//        if(token==null||token.equalsIgnoreCase(""))
//        {
//            token=token;
//        }
//        String[] arr = new String[]{
//            token, timestamp, nonce
//        };
//        Arrays.sort(arr,String.CASE_INSENSITIVE_ORDER);
//        String arrString = String.join("",arr);
//        //var enText = FormsAuthentication.HashPasswordForStoringInConfigFile(arrString, "SHA1");//使用System.Web.Security程序集
//        var sha1 = SHA1.Create();
//        var sha1Arr = sha1.ComputeHash(Encoding.UTF8.GetBytes(arrString));
//        StringBuilder enText = new StringBuilder();
//        foreach(var b in sha1Arr)
//        {
//            enText.AppendFormat("{0:x2}", b);
//        }
//
//        return enText.ToString();
    }
}
