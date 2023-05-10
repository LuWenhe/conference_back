package edu.conf.handler;

import edu.conf.entity.Image;
import edu.conf.service.ImageService;
import edu.conf.utils.ImageUtils;
import edu.conf.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 图片操作
 */
@Api(tags = "图片操作")
@RestController
public class ImageHandler {

    @Resource
    private ImageService imageService;

    @ApiOperation(value = "查询每个小标题下的所有图片")
    @GetMapping("/getImages/{newsCategoryId}")
    public Result getImages(@PathVariable("newsCategoryId") Integer newsCategoryId) {
        List<Image> images = imageService.showImagesByNewsCategoryId(newsCategoryId);

        // 如果该小标题下没有图片
        if (images == null) {
            return new Result().fail("该标题下没有图片");
        }

        return new Result().ok().data(images);
    }

    @ApiOperation(value = "上传单个图片")
    @PostMapping("/uploadImage")
    public Result filesUpload(MultipartFile file, String imageDirectory) throws IOException {
        String s = ImageUtils.uploadImage(file, imageDirectory, false);

        // 如果图片为空
        if (StringUtils.isEmpty(s)) {
            return new Result().fail("上传图片失败");
        }

        return new Result().ok();
    }

    @ApiOperation(value = "保存图片信息")
    @PostMapping("/saveImage")
    public Result uploadImage(@RequestBody Image image) {
        boolean res = imageService.addImage(image);

        if (!res) {
            return new Result().fail("保存图片信息失败");
        }

        return new Result().ok();
    }

}
