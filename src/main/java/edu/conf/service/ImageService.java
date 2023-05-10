package edu.conf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.conf.entity.Image;

import java.util.List;

public interface ImageService extends IService<Image> {

    String ID = "id";
    String IMAGE_TITLE = "IMAGE_TITLE";
    String IMAGE_URL = "IMAGE_URL";
    String IMAGE_HREF = "IMAGE_HREF";
    String IMAGE_COMMENT = "IMAGE_COMMENT";
    String NEWS_CATEGORY_ID = "news_category_id";

    /**
     * 根据newsCategoryId查看下面的所有图片
     */
    List<Image> showImagesByNewsCategoryId(Integer newsCategoryId);

    /**
     * 将图片对象保存至数据库
     */
    boolean addImage(Image image);

    /**
     * 根据id删除数据库中的图片对象
     */
    boolean deleteImage(Integer imageId);

}
