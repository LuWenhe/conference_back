package com.kj.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingFuzzyQueryListByTitleVO {

    private String title;
    private Integer current;
    private Integer size;

}
