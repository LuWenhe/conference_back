package edu.conf.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationAddVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
