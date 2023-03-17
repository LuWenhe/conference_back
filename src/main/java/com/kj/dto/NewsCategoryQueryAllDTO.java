package com.kj.dto;

import com.kj.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryQueryAllDTO {

    private Integer id;

    private String name;

    private String newsTypeName;

    private DisplayContent displayContent;
}
