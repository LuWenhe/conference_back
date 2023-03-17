package com.kj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员修改密码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationUpdateDTO {

    private String username;

    /**
     * 密码
     */
    private String password;
}
