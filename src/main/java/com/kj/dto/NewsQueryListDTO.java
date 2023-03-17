package com.kj.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询新闻列表时返回的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsQueryListDTO {

    private String picturePath;
    private Integer id;
    private String title;
    private Date releaseTime;

}
