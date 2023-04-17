package com.kj.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class HashUtils {

    //干扰数据盐防破解
    private static final String SALT = "JF%2#K";

    //散列算法类型为MD5
    private static final String ALGORITH_NAME = "MD5";

    //hash的次数
    private static final int HASH_ITERATIONS = 1024;

    public static String encrypt(String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toString();
    }

    public static String encrypt(String username, String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(username), HASH_ITERATIONS).toString();
    }

}
