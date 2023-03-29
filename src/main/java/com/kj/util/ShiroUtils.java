package com.kj.util;

import com.kj.dto.Principal;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

    public static Principal getPrincipal() {
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }

}
