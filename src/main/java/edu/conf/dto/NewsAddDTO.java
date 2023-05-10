package edu.conf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsAddDTO {

    private MultipartFile pictureFile;
    private String picturePath;
    private String title;
    private Date releaseTime;
    private String mdContent;
    private String htmlContent;
    private Integer newsCategoryId;

}
