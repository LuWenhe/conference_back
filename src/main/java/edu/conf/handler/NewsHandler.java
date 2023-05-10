package edu.conf.handler;

import edu.conf.annotation.LogAnnotation;
import edu.conf.dto.NewsAddDTO;
import edu.conf.dto.NewsQueryDTO;
import edu.conf.dto.NewsUpdateDTO;
import edu.conf.utils.ImageUtils;
import edu.conf.service.NewsService;
import edu.conf.vo.Result;
import edu.conf.vo.news.NewsAddVO;
import edu.conf.vo.news.NewsUpdateVO;
import edu.conf.vo.news.PagingFuzzyQueryListByTitleVO;
import edu.conf.vo.news.PagingQueryListByNewsCategoryIdVO;
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

    @LogAnnotation(operator = "根据id获取信息")
    @ApiOperation("根据信息id获取信息")
    @GetMapping("/main/{id}")
    public Result queryNewsById(@PathVariable("id") Integer id) {
        NewsQueryDTO news = newsService.getNewsById(id);
        return new Result().ok().data(news);
    }

    @LogAnnotation(operator = "根据category_id获取信息")
    @ApiOperation("根据new_category的id获取新闻信息")
    @GetMapping("/get/{newCategoryId}")
    public Result getNewsByNewCategoryId(@PathVariable("newCategoryId") Integer newCategoryId) {
        NewsQueryDTO newsQueryDTO = newsService.getNewByNewCategoryId(newCategoryId);

        if (newsQueryDTO == null) {
            return new Result().ok().data("新闻列表为空");
        }

        return new Result().ok().data(newsQueryDTO);
    }

    @LogAnnotation(operator = "添加信息")
    @ApiOperation(value = "添加新闻")
    @PostMapping(value = "/add")
    public Result addNews(MultipartFile pictureFile, NewsAddVO vo) throws IOException {
        NewsAddDTO newsAddDTO = modelMapper.map(vo, NewsAddDTO.class);
        newsAddDTO.setPictureFile(pictureFile);
        return new Result().ok().data(newsService.saveNews(newsAddDTO));
    }

    @LogAnnotation(operator = "添加图片")
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
        if (ImageUtils.ifExistsPicture(pictureFile, imageDirectory)) {
            picturePath = imageURL + "/image/" + pictureFile.getOriginalFilename();
        } else {
            String savePath = newsService.saveMDImage(newsAddDTO, imageDirectory);
            picturePath = imageURL + "/" + savePath;
        }

        return new Result().ok().data(picturePath);
    }

    @LogAnnotation(operator = "删除图片")
    @ApiOperation(value = "删除图片")
    @PostMapping(value = "/deleteImage")
    public Result deleteImage(@RequestParam("image") MultipartFile pictureFile) {
        NewsAddDTO newsAddDTO = new NewsAddDTO();
        newsAddDTO.setPictureFile(pictureFile);
        boolean isDelete = ImageUtils.deleteImage(pictureFile, imageDirectory);
        return new Result().ok().data(isDelete);
    }

    @LogAnnotation(operator = "添加内容")
    @ApiOperation(value = "添加内容")
    @PostMapping(value = "/addContent")
    public Result addContent(@RequestBody NewsAddVO vo) throws IOException {
        NewsAddDTO newsAddDTO = modelMapper.map(vo, NewsAddDTO.class);
        return new Result().ok().data(newsService.saveNews(newsAddDTO));
    }

    @LogAnnotation(operator = "删除信息")
    @ApiOperation(value = "删除信息")
    @GetMapping("/delete/{newsId}")
    public Result deleteNews(@PathVariable("newsId") Integer newsId) {
        return new Result().ok().data(newsService.removeNews(newsId));
    }

    @LogAnnotation(operator = "修改信息")
    @ApiOperation(value = "修改信息")
    @PostMapping("/update")
    public Result updateNews(@RequestBody NewsUpdateVO vo) throws IOException {
        NewsUpdateDTO newsUpdateDTO = modelMapper.map(vo, NewsUpdateDTO.class);
        return new Result().ok().data(newsService.updateNews(newsUpdateDTO, imageDirectory));
    }

    @ApiOperation(value = "分页查询指定小标题下的新闻列表，可指定当前页和每页条数")
    @PostMapping("/list")
    public Result pagingQueryListByNewsCategoryId(PagingQueryListByNewsCategoryIdVO vo) {
        return new Result().ok().data(newsService.getNewsListByNewsCategoryId(vo.getNewsCategoryId(),
                vo.getCurrent(), vo.getSize()));
    }

    @ApiOperation(value = "根据新闻标题模糊查询新闻列表，分页查新")
    @PostMapping("/fuzzy")
    public Result pagingFuzzyQueryListByTitle(PagingFuzzyQueryListByTitleVO vo) {
        return new Result().ok().data(newsService.fuzzyQueryListByTitle(vo.getTitle(), vo.getCurrent(), vo.getSize()));
    }

}
