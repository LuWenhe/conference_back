package edu.conf.handler;

import edu.conf.dto.NewsCategoryDTO;
import edu.conf.dto.NewsCategorySaveDTO;
import edu.conf.service.NewsCategoryService;
import edu.conf.vo.Result;
import edu.conf.vo.news.category.NewsCategoryAddVO;
import edu.conf.vo.news.category.NewsCategoryListVO;
import edu.conf.vo.news.category.NewsCategoryUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "新闻类别操作（小标题）")
@RestController
@RequestMapping("/news_category")
public class NewsCategoryHandler {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsCategoryService newsCategoryService;

    @ApiOperation(value = "添加新闻类别")
    @PostMapping("/add")
    public Result addNewsCategory(NewsCategoryAddVO vo){
        return new Result().ok().data(newsCategoryService.saveNewsCategory(modelMapper.map(vo, NewsCategorySaveDTO.class)));
    }

    @ApiOperation(value = "删除新闻类别")
    @PostMapping("/delete")
    public Result deleteNewsCategory(Integer id) {
        return new Result().ok().data(newsCategoryService.removeNewsCategoryById(id));
    }

    @ApiOperation(value = "修改新闻类别")
    @PostMapping("/update")
    public Result updateNewsCategory(@RequestBody NewsCategoryUpdateVO vo) {
        return new Result().ok().data(newsCategoryService.updateNewsCategoryById(modelMapper.map(vo, NewsCategoryDTO.class)));
    }

    @ApiOperation(value = "查询全部新闻类别")
    @GetMapping("/all")
    public Result queryAll() {
        return new Result().ok().data(newsCategoryService.queryAll());
    }

    @ApiOperation(value = "根据newsTypeId查询新闻类别列表")
    @GetMapping("/list/{typeId}")
    public Result queryByNewsTypeId(@PathVariable("typeId") Integer id) {
        List<NewsCategoryDTO> list = newsCategoryService.queryNewCategoryByNewsTypeDd(id);
        return new Result().ok().data(modelMapper.map(list, new TypeToken<List<NewsCategoryListVO>>(){}.getType()));
    }
}
