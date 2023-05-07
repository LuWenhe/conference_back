package edu.conf.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员修改密码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationUpdateVO {

    private String username;

    /**
     * 原来的密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String Password;
}
