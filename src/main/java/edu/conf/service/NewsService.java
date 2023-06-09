package edu.conf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.conf.entity.News;
import edu.conf.dto.NewsAddDTO;
import edu.conf.dto.NewsPaging;
import edu.conf.dto.NewsQueryDTO;
import edu.conf.dto.NewsUpdateDTO;

import java.io.IOException;

public interface NewsService extends IService<News> {

    String PICTURE_PATH = "picture_path";
    String ID = "id";
    String TITLE = "title";
    String RELEASE_TIME = "release_time";
    String HITS = "hits";
    String HTML_CONTENT = "html_content";
    String MD_CONTENT = "md_content";
    String NEWS_CATEGORY_ID = "news_category_id";
    String CREATE_TIME = "create_time";
    String UPDATE_TIME = "update_time";

    /**
     * 添加新闻
     */
    boolean saveNews(NewsAddDTO dto) throws IOException;

    /**
     * 添加Markdown中的图片
     */
    String saveMDImage(NewsAddDTO dto, String imageDirectory) throws IOException;

    /**
     * 删除Markdown中的图片
     */
    boolean deleteMDImage(NewsAddDTO dto, String imageDirectory) throws IOException;

    /**
     * 根据id删除新闻
     */
    boolean removeNews(Integer id);

    /**
     * 修改新闻
     */
    boolean updateNews(NewsUpdateDTO dto, String imageDirectory) throws IOException;

    /**
     * 根据 NEWS_CATEGORY_ID 获取 新闻展示列表
     */
    NewsPaging getNewsListByNewsCategoryId(Integer newsCategoryId, Integer current, Integer size);

    /**
     * 模糊查询新闻列表 根据 title
     */
    NewsPaging fuzzyQueryListByTitle(String title, Integer current, Integer size);

    /**
     * 获取新闻根据 id
     */
    NewsQueryDTO getNewsById(Integer id);

    /**
     * 根据newCategoryId获取信息
     */
    NewsQueryDTO getNewByNewCategoryId(Integer newCategoryId);

}
