package edu.conf.service;

import edu.conf.dto.NewsCategoryDTO;
import edu.conf.vo.news.category.NewsCategoryListVO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsCategoryServiceTest {

    @Resource
    private NewsCategoryService newsCategoryService;

    @Resource
    private ModelMapper modelMapper;

    @Test
    void queryNewCategoryByNewsTypeDd() {
        List<NewsCategoryDTO> newsCategoryDTOS = newsCategoryService.queryNewCategoryByNewsTypeDd(1);
        List<NewsCategoryListVO> list = modelMapper.map(newsCategoryDTOS, new TypeToken<List<NewsCategoryListVO>>() {}.getType());
        System.out.println(list);
    }

}