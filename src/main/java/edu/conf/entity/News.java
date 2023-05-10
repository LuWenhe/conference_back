package edu.conf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 新闻主体
 */
@TableName("news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String picturePath;        // 图片路径
    private String title;              // 标题
    private Date releaseTime;          // 新闻发布时间
    private Integer hits;              // 点击率
    private String mdContent;
    private String htmlContent;
    private Integer newsCategoryId;    // 文章所属类别
    private Date createTime;
    private Date updateTime;

}
