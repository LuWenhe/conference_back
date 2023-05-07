package edu.conf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 新闻类型（大标题）
 */
@TableName("news_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsType {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;       // 新闻类型名
    private Date createTime;
    private Date updateTime;

}
