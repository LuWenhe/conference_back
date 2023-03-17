package com.kj.vo.news.category;

import com.kj.enums.DisplayContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryAddVO {

    private String name;
    private Integer newsTypeId;
    private DisplayContent displayContent;

}
