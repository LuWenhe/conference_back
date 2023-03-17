package com.kj.vo.news.category;

import com.kj.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryUpdateVO {

    private Integer id;
    private String name;
    private Integer newsTypeId;
    private DisplayContent displayContent;

}
