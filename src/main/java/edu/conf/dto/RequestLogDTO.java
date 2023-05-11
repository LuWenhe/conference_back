package edu.conf.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLogDTO {

    // 请求ID（UUID）与 ResponseLogVo id 一致
    private String id;

    // 接口URI
    @JSONField(ordinal = 1)
    private String uri;

    // 操作名称
    @JSONField(ordinal = 2)
    private String operator;

    // 请求方法
    @JSONField(ordinal = 3)
    private String name;

    // 参数数组
    @JSONField(ordinal = 4)
    private Object[] args;

    // 是否需要认证
    @JSONField(ordinal = 5)
    private Boolean auth;

    // 认证令牌
    @JSONField(ordinal = 6)
    private String token;

    // 登录账号信息
    @JSONField(ordinal = 7)
    private Object loginAccount;

    // 类名+方法名
    @JSONField(ordinal = 8)
    private String path;

    // 页面引用
    @JSONField(ordinal = 9)
    private String referer;

    // 请求地址
    @JSONField(ordinal = 10)
    private String remoteAddr;

    // 用户代理（浏览器）
    @JSONField(ordinal = 11)
    private String userAgent;

}
