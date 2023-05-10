package edu.conf.dto;

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
    private String mdContent;
    private String htmlContent;

}
