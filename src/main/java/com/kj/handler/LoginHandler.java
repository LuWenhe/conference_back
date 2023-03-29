package com.kj.handler;

import com.kj.entity.AdminInformation;
import com.kj.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录")
@RestController
@Slf4j
public class LoginHandler {

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody AdminInformation adminInformation) {
        Subject subject = SecurityUtils.getSubject();

        // 登陆过先退出
        if (subject.isAuthenticated()) {
            subject.logout();
        }

        UsernamePasswordToken token = new UsernamePasswordToken(adminInformation.getUsername(), adminInformation.getPassword());
        subject.login(token);
        log.info("{}登录成功 sessionID：{}", subject.getPrincipal(), subject.getSession().getId());
        return new Result().ok().data(subject.getPrincipal()).cookie(subject.getSession().getId().toString());
    }

    @ApiOperation(value = "注销")
    @PostMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result().ok().data(!subject.isAuthenticated());
    }
}
