package com.kj.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingQueryListByNewsCategoryIdVO {

    private Integer newsCategoryId;
    private Integer current;
    private Integer size;

}
