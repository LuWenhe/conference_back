package edu.conf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片对象
 */
@TableName("image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String imageTitle;
    private String imageUrl;
    private String imageHref;
    private String imageComment;
    private String newsCategoryId;

}
