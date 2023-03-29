package com.kj.vo.admin;

import com.kj.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationVO {

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private AdminRole role;
}
