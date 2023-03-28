package com.kj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kj.dto.*;
import com.kj.entity.News;
import com.kj.entity.NewsCategory;
import com.kj.enums.DisplayContent;
import com.kj.exception.HintException;
import com.kj.mapper.NewsCategoryMapper;
import com.kj.mapper.NewsMapper;
import com.kj.util.ImgUtils;
import com.kj.service.NewsCategoryService;
import com.kj.service.NewsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsCategoryMapper newsCategoryMapper;

    @Override
    public boolean saveNews(NewsAddDTO dto) throws IOException {
        if (nonentityNewsCategory(dto.getNewsCategoryId())) {
            throw new HintException("此新闻类别不存在");
        }

        // 获取新闻类别
        NewsCategory newsCategory = newsCategoryMapper.selectOne(new QueryWrapper<NewsCategory>()
                .select(NewsCategoryService.DISPLAY_CONTENT).eq(NewsCategoryService.ID, dto.getNewsCategoryId()));

        // 如果新闻类型是新闻，则标题下只能存储一篇新闻
        if (newsCategory.getDisplayContent() == DisplayContent.NEWS) {
            // 检查该标题下是否存在新闻
            int count = count(new QueryWrapper<News>().eq(NEWS_CATEGORY_ID, dto.getNewsCategoryId()));

            if (count >= 1) {
                throw new HintException("该类别下只能存在一篇新闻");
            }
        }

//        // 如果上传的图片不为空, 则保存图片
//        if (dto.getPictureFile() != null) {
//            String s = ImgUtils.uploadImage(dto.getPictureFile());
//            dto.setPicturePath(s);
//        }

        return save(modelMapper.map(dto, News.class));
    }

    @Override
    public String saveImage(NewsAddDTO dto, String imageDirectory) throws IOException {
        return ImgUtils.uploadImage(dto.getPictureFile(), imageDirectory);
    }

    @Override
    public boolean deleteImage(NewsAddDTO dto, String imageDirectory) throws IOException {
        return ImgUtils.deleteImage(dto.getPictureFile(), imageDirectory);
    }

    @Override
    public boolean removeNews(Integer id) {
        return removeById(id);
    }

    @Override
    public boolean updateNews(NewsUpdateDTO dto, String imageDirectory) throws IOException {
        // 查看新闻是否存在
        int count1 = count(new QueryWrapper<News>().eq(ID, dto.getId()));

        if (count1 < 1) {
            throw new HintException("id为" + dto.getId() + "的新闻不存在");
        }

        if (dto.getNewsCategoryId() != null && nonentityNewsCategory(dto.getNewsCategoryId())) {
            throw new HintException("此新闻类别不存在");
        }

        // dto.getNewsCategoryId() 不为null 说明新闻类别可能会更改，需要判断更改后的类别是否是只能存储一篇新闻的展示新闻类型
        if (dto.getNewsCategoryId() != null) {
            Integer newCategoryId = dto.getNewsCategoryId();
            NewsCategory newsCategory = newsCategoryMapper.selectOne(new QueryWrapper<NewsCategory>()
                    .select(NewsCategoryService.DISPLAY_CONTENT).eq(NewsCategoryService.ID, newCategoryId));

            if (newsCategory.getDisplayContent() == DisplayContent.NEWS) {
                // 检查该标题下是否存在新闻
                int count = count(new QueryWrapper<News>().eq(NEWS_CATEGORY_ID, newCategoryId));
                if (count >= 1) {
                    throw new HintException("该类别下只能存在一篇新闻");
                }
            }
        }

        // 需要修改图片
        if (dto.getPictureFile() != null) {
            String s = ImgUtils.uploadImage(dto.getPictureFile(), imageDirectory);
            dto.setPicturePath(s);
        }

        return updateById(modelMapper.map(dto, News.class));
    }

    @Override
    public NewsPaging getNewsListByNewsCategoryId(Integer newsCategoryId, Integer current, Integer size) {
        Page<News> page = page(new Page<>(current, size), new QueryWrapper<News>().select(ID, TITLE, RELEASE_TIME, PICTURE_PATH).eq(NEWS_CATEGORY_ID, newsCategoryId).orderByDesc(RELEASE_TIME));
        NewsPaging newsPaging = modelMapper.map(page, NewsPaging.class);
        List<News> records = page.getRecords();
        newsPaging.setRecords(modelMapper.map(records, new TypeToken<List<NewsQueryListDTO>>(){}.getType()));
        return newsPaging;
    }

    @Override
    public NewsQueryDTO getNewsById(Integer id) {
        // 新闻点击率加一
        News one = getOne(new QueryWrapper<News>().select(HITS).eq(ID, id));

        if (one == null) {
            return null;
        }

        update(new UpdateWrapper<News>().set(HITS, one.getHits() + 1).eq(ID, id));
        return modelMapper.map(getById(id), NewsQueryDTO.class);
    }

    @Override
    public NewsPaging fuzzyQueryListByTitle(String title, Integer current, Integer size) {
        Page<News> page = page(new Page<>(current, size), new QueryWrapper<News>().select(ID, TITLE, RELEASE_TIME, PICTURE_PATH).like(TITLE, title).orderByDesc(RELEASE_TIME));
        NewsPaging newsPaging = modelMapper.map(page, NewsPaging.class);
        List<News> records = page.getRecords();
        newsPaging.setRecords(modelMapper.map(records, new TypeToken<List<NewsQueryListDTO>>(){}.getType()));
        return newsPaging;
    }

    /**
     * 不存在 NewsCategory
     */
    private boolean nonentityNewsCategory(Integer newsCategoryId) {
        Integer count = newsCategoryMapper.selectCount(new QueryWrapper<NewsCategory>().eq(NewsCategoryService.ID, newsCategoryId));
        return count < 1;
    }
}
