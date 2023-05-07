package edu.conf.handler;

import edu.conf.utils.ImgUtils;
import edu.conf.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传图片操作
 */
@Slf4j
@Api(tags = "其他操作")
@RestController
public class OperationHandler {

//    @GeneralAdmin
    @ApiOperation(value = "单文件上传")
    @PostMapping("/uploading")
    public Result filesUpload(MultipartFile file, String imageDirectory) throws IOException {
        String s = ImgUtils.uploadImage(file, imageDirectory);
        return new Result().ok().data(s);
    }

}
