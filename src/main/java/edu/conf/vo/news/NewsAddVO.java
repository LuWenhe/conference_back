package edu.conf.vo.news;

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
public class NewsAddVO {

    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    private String content;
    private String mdContent;
    private String htmlContent;
    private Integer newsCategoryId;

}
