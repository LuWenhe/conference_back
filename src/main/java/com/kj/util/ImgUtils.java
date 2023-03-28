package com.kj.util;

import com.kj.exception.HintException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 处理图片的工具类
 */
@Slf4j
public class ImgUtils {

    private static final String FILE_PATH_PREFIX_READ = "image";

    //文件路径后缀
    private static final String FILE_PATH_SUFFIX = ".png";

    // 默认的图片后缀
    private static final List<String> FILE_TYPE = Arrays.asList("image/jpeg", "image/png");

    public static String uploadImage(MultipartFile file, String imageDirectory) throws IOException, HintException {
        if (!FILE_TYPE.contains(file.getContentType())) {
            throw new HintException("上传的文件类型只能是:" + FILE_TYPE);
        }

        File upload = new File(imageDirectory);

        log.info("目录upload: " + upload);

        if (!upload.exists()) {
            log.info("目录不存在，开始创建: " + upload);
            if (!upload.mkdirs()) {
                throw new HintException("文件上传失败");
            }
        }

        UUID fileName = UUID.randomUUID();
        if (!file.isEmpty()) {
            log.info("开始保存");
            File file1 = new File(upload, fileName + FILE_PATH_SUFFIX);
            // 保存文件
            file.transferTo(file1);
            log.info("保存结束");
        } else {
            throw new NullPointerException("文件不能为空");
        }

        return FILE_PATH_PREFIX_READ + "/" + fileName + FILE_PATH_SUFFIX;
    }

    public static boolean deleteImage(MultipartFile multipartFile, String imageDirectory) throws HintException {
        File pictureFile = getPictureFile(multipartFile, imageDirectory);

        if (pictureFile == null) {
            return false;
        }

        return pictureFile.delete();
    }

    // 图片是否存在
    public static boolean ifExistsPicture(MultipartFile multipartFile, String imageDirectory) {
        File pictureFile = getPictureFile(multipartFile, imageDirectory);

        if (pictureFile == null) {
            return false;
        }

        return pictureFile.exists();
    }

    // 得到图片文件对象
    public static File getPictureFile(MultipartFile multipartFile, String imageDirectory) {
        String filename = multipartFile.getOriginalFilename();

        if (filename == null) {
            return null;
        }

        return new File(imageDirectory, filename);
    }

    /*public static String getPortraitPath(String headPortraitId) {
        // 检查文件是否存在，不存在使用默认文件路径
        String path = System.getProperty("user.dir");
        File upload = new File(path, FILE_PATH_PREFIX + File.separator + headPortraitId + FILE_PATH_SUFFIX);
        if (!upload.exists()) {
            return FILE_PATH_PREFIX_READ + File.separator + DEFAULT_HEAD_PORTRAIT + FILE_PATH_SUFFIX;
        }
        return FILE_PATH_PREFIX_READ + File.separator + headPortraitId + FILE_PATH_SUFFIX;
    }

    public static void deleteOutdatedPhotos(String fileName) {
        if (DEFAULT_HEAD_PORTRAIT.equals(fileName)) {
            return;
        }
        String path = System.getProperty("user.dir");
        String filePath = FILE_PATH_PREFIX + File.separator + fileName + FILE_PATH_SUFFIX;
        File delete = new File(path, filePath);
        delete.delete();
    }*/

}
