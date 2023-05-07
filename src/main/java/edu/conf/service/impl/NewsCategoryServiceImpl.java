package edu.conf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.conf.dto.NewsCategoryDTO;
import edu.conf.dto.NewsCategoryQueryAllDTO;
import edu.conf.dto.NewsCategorySaveDTO;
import edu.conf.entity.NewsCategory;
import edu.conf.entity.NewsType;
import edu.conf.exception.HintException;
import edu.conf.mapper.NewsCategoryMapper;
import edu.conf.mapper.NewsTypeMapper;
import edu.conf.service.NewsCategoryService;
import edu.conf.service.NewsTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements NewsCategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsTypeMapper newsTypeMapper;

    @Override
    public boolean saveNewsCategory(NewsCategorySaveDTO dto) {
        if (nonentityNewsType(dto.getNewsTypeId())) {
            throw new HintException("此新闻类型不存在");
        }
        return save(modelMapper.map(dto, NewsCategory.class));
    }

    @Override
    public boolean removeNewsCategoryById(Integer id) {
        return removeById(id);
    }

    @Override
    public boolean updateNewsCategoryById(NewsCategoryDTO dto) {
        if (dto.getNewsTypeId() != null && nonentityNewsType(dto.getNewsTypeId())) {
            throw new HintException("此新闻类型不存在");
        }
        return updateById(modelMapper.map(dto, NewsCategory.class));
    }

    @Override
    public List<NewsCategoryQueryAllDTO> queryAll() {
        List<NewsCategory> list = list(new QueryWrapper<NewsCategory>().select(ID, NAME, NEWS_TYPE_ID, DISPLAY_CONTENT));
        return list.stream().map(this::newsTypeIdToString).collect(Collectors.toList());
    }

    @Override
    public List<NewsCategoryDTO> queryNewCategoryByNewsTypeDd(Integer newsTypeId) {
        List<NewsCategory> list = list(new QueryWrapper<NewsCategory>().select(ID, NAME, DISPLAY_CONTENT)
                .eq(NEWS_TYPE_ID, newsTypeId));
        return modelMapper.map(list, new TypeToken<List<NewsCategoryDTO>>(){}.getType());
    }


    /**
     * 不存在 NewsType
     */
    private boolean nonentityNewsType(Integer newsTypeId) {
        Integer count = newsTypeMapper.selectCount(new QueryWrapper<NewsType>().eq(NewsTypeService.ID, newsTypeId));
        return count < 1;
    }

    /**
     * 通过NewsType 的 ID 获取 Name
     */
    public NewsCategoryQueryAllDTO newsTypeIdToString(NewsCategory newsCategory) {
        String name = newsTypeMapper.selectOne(new QueryWrapper<NewsType>().select(NewsTypeService.NAME).eq(NewsTypeService.ID, newsCategory.getNewsTypeId())).getName();
        NewsCategoryQueryAllDTO map = modelMapper.map(newsCategory, NewsCategoryQueryAllDTO.class);
        map.setNewsTypeName(name);
        return map;
    }
}
