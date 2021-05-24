package per.wkz.rookie.utils;

import org.apache.commons.codec.binary.Base64;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;

import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;

import java.security.SecureRandom;

public class UrlUtils {
    private static final String KEY = "myoMwO6qPt&3AD";

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlUtils.class);

    public static String enCryptAndEncode(String content) {
        try {
            byte[] sourceBytes = enCryptAndEncode(content, KEY);

            return Base64.encodeBase64URLSafeString(sourceBytes);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);

            return content;

        }

    }

    /**

     * 加密函数

     * @param content 加密的内容

     * @param strKey 密钥

     * @return 返回二进制字符数组

     * @throws Exception

     */

    public static byte[] enCryptAndEncode(String content, String strKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

        SecretKey desKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, desKey);

        return cipher.doFinal(content.getBytes("UTF-8"));

    }

    public static String deCryptAndDecode(String content) throws Exception {
        byte[] targetBytes = Base64.decodeBase64(content);

        return deCryptAndDecode(targetBytes, KEY);

    }

    /**

     * 解密函数

     * @param src 加密过的二进制字符数组

     * @param strKey 密钥

     * @return

     * @throws Exception

     */

    public static String deCryptAndDecode(byte[] src, String strKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

        SecretKey desKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, desKey);

        byte[] cByte = cipher.doFinal(src);

        return new String(cByte, "UTF-8");

    }

}
