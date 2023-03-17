package com.kj.vo.news;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsUpdateVO {

    private Integer id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    private Integer hits;
    private String content;
    private String mdContent;
    private String htmlContent;
    private Integer newsCategoryId;

}
