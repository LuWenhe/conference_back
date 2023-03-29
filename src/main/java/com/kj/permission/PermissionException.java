package com.kj.permission;

public class PermissionException extends RuntimeException {

    public PermissionException() {
        super("权限不足");
    }
}
