package edu.conf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import edu.conf.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 管理员信息表
 */
@TableName("admin_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private AdminRole role;
    private Date createTime;
    private Date updateTime;

}
