package edu.conf.vo.news.category;

import edu.conf.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryListVO {

    private Integer id;
    private String name;
    private DisplayContent displayContent;

}
