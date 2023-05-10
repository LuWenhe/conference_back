package edu.conf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.conf.entity.Image;
import edu.conf.entity.NewsType;
import edu.conf.mapper.ImageMapper;
import edu.conf.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public List<Image> showImagesByNewsCategoryId(Integer newsCategoryId) {
        return imageMapper.selectList(new QueryWrapper<Image>()
                .select(ID, IMAGE_TITLE, IMAGE_URL, IMAGE_HREF, IMAGE_COMMENT)
                .eq(NEWS_CATEGORY_ID, newsCategoryId));
    }

    @Override
    public boolean addImage(Image image) {
        return save(image);
    }

    @Override
    public boolean deleteImage(Integer imageId) {
        return removeById(imageId);
    }

}
