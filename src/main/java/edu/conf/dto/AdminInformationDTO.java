package edu.conf.dto;

import edu.conf.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 管理员信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationDTO {

    private Integer id;
    private String username;
    private String password;
    private AdminRole role;

}
