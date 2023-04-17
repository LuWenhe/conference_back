package com.kj.vo;

import com.kj.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private Integer code;

    private boolean success;

    private String msg;

    private Object data;

    private String token;

    public Result() {
    }

    public Result ok() {
        return field(this, ResultCode.OK);
    }

    public Result fail() {
        return field(this, ResultCode.FAIL);
    }

    public Result fail(String msg) {
        Result fail = fail();
        fail.setMsg(msg);
        return fail;
    }

    public Result insufficientPermissions() {
        return field(this, ResultCode.PERMISSION);
    }

    public Result insufficientPermissions(String msg) {
        Result insufficientPermissions = insufficientPermissions();
        insufficientPermissions.setMsg(msg);
        return insufficientPermissions;
    }

    public Result notFound() {
        return field(this, ResultCode.NOTFOUND);
    }

    // 链式编程
    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public Result token(String token) {
        this.token = token;
        return this;
    }

    private Result field(Result result, ResultCode code) {
        result.setCode(code.getCode());
        result.setSuccess(code.getSuccess());
        result.setMsg(code.getMsg());
        return result;
    }

}
