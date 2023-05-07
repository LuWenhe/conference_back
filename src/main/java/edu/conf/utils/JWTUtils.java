package edu.conf.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String SIGN = "!Q@EeKE^EN%KN";
    private static final long TIME = 1000*60*60*24;

    /**
     * 生成token
     */
    public static String getToken(Map<String, String> map) {
        // 创建JWT的Builder
        JWTCreator.Builder builder = JWT.create();

        // 生成payload, 存入用户id和用户名
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.withClaim(entry.getKey(), entry.getValue());
        }

        // 生成token字符串
        return builder
                .withExpiresAt(new Date(System.currentTimeMillis() + TIME))
                .sign(Algorithm.HMAC256(SIGN));
    }

    /**
     * 验证token合法性
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

}
