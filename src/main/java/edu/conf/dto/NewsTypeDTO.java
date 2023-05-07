package edu.conf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新闻类型（大标题）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsTypeDTO {

    private Integer id;
    private String name;    // 新闻类型名

}
