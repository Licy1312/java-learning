package com.java.learning.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by lichangya on 2018/7/29.
 */
public abstract class Base64 {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBase64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBase64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key).replace("\r", "").replace("\n", "");
    }
}
