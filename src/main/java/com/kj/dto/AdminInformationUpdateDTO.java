package com.kj.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kj.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 破晓
 * @date 2022-01-23 16:22
 *
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
