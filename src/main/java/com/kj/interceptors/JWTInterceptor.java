package com.kj.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.kj.entity.Constants;
import com.kj.exception.HintException;
import com.kj.util.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器类
 */
public class JWTInterceptor implements HandlerInterceptor {

    /**
     * 在处理请求之前调用该方法, 如果返回true则继续向下执行, 返回false则放弃执行
     * <p>
     * 判断从前端发来请求的请求头是否包括token字符串, 如果没有则直接抛出异常
     * 如果有则验证token的有效性, 如果有效则直接放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        // 拿到前端请求头中的令牌
        String token = request.getHeader("token");

        if (token == null) {
            throw new HintException(Constants.CODE_401, "没有token, 请重新登录");
        }

        try {
            // 验证令牌
            JWTUtils.verify(token);
            // 如果验证通过, 则放行请求
            return true;
        } catch (SignatureVerificationException e) {
            throw new HintException(Constants.CODE_401, "无效签名!");
        } catch (TokenExpiredException e) {
            throw new HintException(Constants.CODE_401, "token已过期!");
        } catch (AlgorithmMismatchException e) {
            throw new HintException(Constants.CODE_401, "token算法不一致!");
        } catch (JWTVerificationException e) {
            throw new HintException(Constants.CODE_401, "token验证失败!");
        }
    }

}
