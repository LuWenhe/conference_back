package com.kj.vo.news.category;

import com.kj.enums.DisplayContent;
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
