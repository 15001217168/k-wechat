package weixin.entities.request;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 15:15 2018/6/20
 * @Modified By:
 */
public class EncryptPostModel {

    private String signature;
    private String msgSignature;
    private String timestamp;
    private String nonce;
    private String token;
    private String encodingAESKey;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    public void setSecretInfo(String token, String encodingAESKey) {
        token = token;
        encodingAESKey = encodingAESKey;
    }
}
