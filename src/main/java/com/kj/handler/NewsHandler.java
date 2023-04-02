package com.kj.handler;

import com.kj.dto.NewsAddDTO;
import com.kj.dto.NewsQueryDTO;
import com.kj.dto.NewsUpdateDTO;
import com.kj.util.ImgUtils;
import com.kj.permission.annotation.GeneralAdmin;
import com.kj.service.NewsService;
import com.kj.vo.Result;
import com.kj.vo.news.NewsAddVO;
import com.kj.vo.news.NewsUpdateVO;
import com.kj.vo.news.PagingFuzzyQueryListByTitleVO;
import com.kj.vo.news.PagingQueryListByNewsCategoryIdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "新闻主体操作")
@Slf4j
@RestController
@RequestMapping("/news")
public class NewsHandler {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsService newsService;

    @Value("${image.url}")
    private String imageURL;

    @Value("${image.directory}")
    private String imageDirectory;

    @ApiOperation("根据新闻id获取新闻")
    @GetMapping("/main/{id}")
    public Result queryNewsById(@PathVariable("id") Integer id) {
        NewsQueryDTO news = newsService.getNewsById(id);
        return new Result().ok().data(news);
    }

    @ApiOperation("根据new_category的id获取新闻信息")
    @GetMapping("/get/{newCategoryId}")
    public Result getNewByNewCategoryId(@PathVariable("newCategoryId") Integer newCategoryId) {
        NewsQueryDTO newsQueryDTO = newsService.getNewByNewCategoryId(newCategoryId);
        return new Result().ok().data(newsQueryDTO);
    }

    @GeneralAdmin
    @ApiOperation(value = "添加新闻")
    @PostMapping(value = "/add")
    public Result addNews(MultipartFile pictureFile, NewsAddVO vo) throws IOException {
        NewsAddDTO newsAddDTO = modelMapper.map(vo, NewsAddDTO.class);
        newsAddDTO.setPictureFile(pictureFile);
        return new Result().ok().data(newsService.saveNews(newsAddDTO));
    }

    @GeneralAdmin
    @ApiOperation(value = "添加图片")
    @PostMapping(value = "/addImage")
    public Result addImage(@RequestParam("image") MultipartFile pictureFile)
            throws IOException {
        log.info("imageURL:{}", imageURL);
        log.info("imageDirectory:{}", imageDirectory);
        NewsAddDTO newsAddDTO = new NewsAddDTO();
        newsAddDTO.setPictureFile(pictureFile);
        String picturePath = "";

        // 如果图片存在, 则直接返回图片
        if (ImgUtils.ifExistsPicture(pictureFile, imageDirectory)) {
            picturePath = imageURL + "/image/" + pictureFile.getOriginalFilename();
        } else {
            String savePath = newsService.saveImage(newsAddDTO, imageDirectory);
            picturePath = imageURL + "/" + savePath;
        }

        return new Result().ok().data(picturePath);
    }

    @GeneralAdmin
    @ApiOperation(value = "删除图片")
    @PostMapping(value = "/deleteImage")
    public Result deleteImage(@RequestParam("image") MultipartFile pictureFile) {
        NewsAddDTO newsAddDTO = new NewsAddDTO();
        newsAddDTO.setPictureFile(pictureFile);
        boolean isDelete = ImgUtils.deleteImage(pictureFile, imageDirectory);
        return new Result().ok().data(isDelete);
    }

    @GeneralAdmin
    @ApiOperation(value = "添加内容")
    @PostMapping(value = "/addContent")
    public Result addContent(@RequestBody NewsAddVO vo) throws IOException {
        NewsAddDTO newsAddDTO = modelMapper.map(vo, NewsAddDTO.class);
        return new Result().ok().data(newsService.saveNews(newsAddDTO));
    }

    @GeneralAdmin
    @ApiOperation(value = "删除新闻")
    @PostMapping("/delete")
    public Result deleteNews(Integer id) {
        return new Result().ok().data(newsService.removeNews(id));
    }

    @GeneralAdmin
    @ApiOperation(value = "修改新闻")
    @PostMapping("/update")
    public Result updateNews(@RequestBody NewsUpdateVO vo) throws IOException {
        NewsUpdateDTO newsUpdateDTO = modelMapper.map(vo, NewsUpdateDTO.class);
        return new Result().ok().data(newsService.updateNews(newsUpdateDTO, imageDirectory));
    }

    @ApiOperation(value = "分页查询指定小标题下的新闻列表，可指定当前页和每页条数")
    @PostMapping("/list")
    public Result pagingQueryListByNewsCategoryId(PagingQueryListByNewsCategoryIdVO vo) {
        return new Result().ok().data(newsService.getNewsListByNewsCategoryId(vo.getNewsCategoryId(), vo.getCurrent(), vo.getSize()));
    }

    @ApiOperation(value = "根据新闻标题模糊查询新闻列表，分页查新")
    @PostMapping("/fuzzy")
    public Result pagingFuzzyQueryListByTitle(PagingFuzzyQueryListByTitleVO vo) {
        return new Result().ok().data(newsService.fuzzyQueryListByTitle(vo.getTitle(), vo.getCurrent(), vo.getSize()));
    }

}
