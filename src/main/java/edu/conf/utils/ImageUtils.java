package edu.conf.utils;

import edu.conf.exception.HintException;
import lombok.extern.slf4j.Slf4j;
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
public class ImageUtils {

    private static final String FILE_PATH_PREFIX_READ = "image";

    // 文件路径后缀
    private static final String FILE_PATH_SUFFIX = ".png";

    // 文件类型
    private static final List<String> FILE_TYPE = Arrays.asList("image/jpeg", "image/png");

    public static String uploadImage(MultipartFile file, String imageDirectory, boolean isMarkdownImage)
            throws IOException, HintException {
        // 判断上传文件是否是图片类型
        if (!FILE_TYPE.contains(file.getContentType())) {
            throw new HintException("上传的文件类型只能是:" + FILE_TYPE);
        }

        File fileDirectory = new File(imageDirectory);

        // 如果目录不存在
        if (!fileDirectory.exists()) {
            log.info("目录不存在，开始创建: " + fileDirectory);
            if (!fileDirectory.mkdirs()) {
                throw new HintException("文件上传失败");
            }
        }

        String fileName;

        // 如果是Markdown的图片, 则重命名图片
        if (isMarkdownImage) {
            fileName = UUID.randomUUID().toString();
        } else {
            fileName = file.getName();
        }

        // 如果文件不为空
        if (!file.isEmpty()) {
            log.info("文件{}开始保存", fileName);
            // 保存文件
            file.transferTo(new File(fileDirectory, fileName + FILE_PATH_SUFFIX));
            log.info("文件{}保存结束", fileName);
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

}
