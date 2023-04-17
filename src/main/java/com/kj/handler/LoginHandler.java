package com.kj.handler;

import com.kj.dto.AdminInformationDTO;
import com.kj.entity.AdminInformation;
import com.kj.enums.ResultCode;
import com.kj.service.AdminInformationService;
import com.kj.util.JWTUtils;
import com.kj.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "登录")
@RestController
@Slf4j
public class LoginHandler {

    @Resource
    private AdminInformationService adminInformationService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody AdminInformation adminInformation) {
        Result result = new Result();
        String username = adminInformation.getUsername();
        String password = adminInformation.getPassword();

        // 检查密码是否正确
        if (adminInformationService.checkPassword(username, password)) {
            AdminInformationDTO adminInformationDTO = adminInformationService.getAdminInformationByUsername(username);
            Map<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(adminInformationDTO.getId()));
            payload.put("username", username);
            // 根据用户id和username得到用户的token
            String token = JWTUtils.getToken(payload);
            result.setMsg("登陆成功");
            result.setCode(ResultCode.OK.getCode());
            result.setToken(token);
            result.setData(adminInformationDTO);
        } else {
            result.setCode(ResultCode.FAIL.getCode());
            result.setMsg("登陆失败");
        }

        return result;
    }

    @ApiOperation(value = "注销")
    @PostMapping("/logout")
    public Result logout() {
        return new Result().ok();
    }

}
