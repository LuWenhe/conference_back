package com.kj.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsQueryDTO {

    private Integer id;
    private String title;
    private Date releaseTime;
    private Integer hits;
    private String content;
    private String mdContent;
    private String htmlContent;

}
