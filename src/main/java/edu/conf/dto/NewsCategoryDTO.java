package edu.conf.dto;

import edu.conf.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryDTO {

    private Integer id;
    private String name;
    private Integer newsTypeId;
    private DisplayContent displayContent;

}
