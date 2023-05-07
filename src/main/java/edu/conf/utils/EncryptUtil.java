package edu.conf.utils;

import cn.hutool.crypto.symmetric.AES;

/**
 *
 */
public class EncryptUtil {

     public static String getEnpPassword(String password) {
        AES aes = new AES("CBC", "PKCS5Padding",
                // 密钥，可以自定义
                "0123456789ABHAEQ".getBytes(),
                // iv加盐，按照实际需求添加
                "DYgjCEIMVrj2W9xN".getBytes());
        // 加密为16进制表示
        String encryptHex = aes.encryptHex(password);
        // 解密
        String decryptStr = aes.decryptStr(encryptHex);
        return encryptHex;
    }

}
