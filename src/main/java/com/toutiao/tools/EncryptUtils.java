package com.toutiao.tools;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 常用加密算法工具类  
 * @author cq
 */
public class EncryptUtils {

    /**
     * 用MD5算法进行加密  
     * @param str 需要加密的字符串  
     * @return MD5加密后的结果
     */
    public static String md5(String str) {
        return encode(str, "MD5");
    }

    /**
     * 用SHA算法进行加密  
     * @param str 需要加密的字符串  
     * @return SHA加密后的结果
     */
    public static String sha(String str) {
        return encode(str, "SHA");
    }

    /**
     * 用base64算法进行加密  
     * @param str 需要加密的字符串  
     * @return base64加密后的结果
     */
    public static String base64(String str) {
        BASE64Encoder encoder =  new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    /**
     * 用base64算法进行解密  
     * @param str 需要解密的字符串  
     * @return base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64(String str) throws IOException {
        BASE64Decoder encoder =  new BASE64Decoder();
        return new String(encoder.decodeBuffer(str));
    }

    private static String encode(String str, String method) {
        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return dstr;
    }

    public static void main(String[] args) throws IOException {
        String user = "111111";
        System.out.println("原始字符串 " + user);
        System.out.println("MD5加密 " + md5(user));
        System.out.println("SHA加密 " + sha(user));
        String base64Str = base64(user);
        System.out.println("Base64加密 " + base64Str);
        System.out.println("Base64解密 " + decodeBase64(base64Str));
    } 
   
}
   