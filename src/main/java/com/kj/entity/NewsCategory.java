package com.kj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kj.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 新闻类别（小标题）
 */
@TableName("news_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategory {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;    // 新闻类别名
    private Integer newsTypeId;    // 所属的新闻类型id
    private DisplayContent displayContent;    // 展示的类型
    private Date createTime;
    private Date updateTime;

}
