package cn.sibat.file.service.util;

import cn.sibat.file.service.controller.exception.CheckTypeException;
import cn.sibat.file.service.controller.exception.RRException;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.util.Arrays;
import java.util.Objects;

/**
 * http://blog.csdn.net/yjw123456/article/details/70312887
 *
 * @author BF
 */

public enum FileCheck {

    /**
     * 检查文件类型
     */
    CHECK;

    private MimetypesFileTypeMap imageFileTypeMap;
    private MimetypesFileTypeMap videoFileTypeMap;
    private MimetypesFileTypeMap textFileTypeMap;

    FileCheck() {
        imageFileTypeMap = new MimetypesFileTypeMap();
        videoFileTypeMap = new MimetypesFileTypeMap();
        textFileTypeMap = new MimetypesFileTypeMap();

        /* 不添加下面的类型会造成误判
        详见：http://stackoverflow.com/questions/4855627/java-mimetypesfiletypemap-always-returning-application-octet-stream-on-android-e*/
        imageFileTypeMap.addMimeTypes("image png tif jpg jpeg bmp JPEG PNG JPG BMP TIF");
        textFileTypeMap.addMimeTypes("text doc docx xls xlxs pdf txt");
        videoFileTypeMap.addMimeTypes("video mp4");
    }

    /**
     * 检查文件类型
     *
     * @param multipartFiles [MultipartFile] 文件流
     * @param fileType       [Integer] 接口定义的文件类型
     */
    public void checkFile(MultipartFile[] multipartFiles, Integer fileType) {
        switch (fileType) {
            case 0:
                Arrays.stream(multipartFiles)
                        .map(e -> checkNameNull(e.getOriginalFilename()))
                        .forEach(this::isImage);
                break;
            case 2:
                Arrays.stream(multipartFiles)
                        .map(e -> checkNameNull(e.getOriginalFilename()))
                        .forEach(this::isText);
                break;
            case 3:
                Arrays.stream(multipartFiles)
                        .map(e -> checkNameNull(e.getOriginalFilename()))
                        .forEach(this::isVideo);
                break;
            default:
                // do nothing
                break;
        }
    }

    /**
     * 检查文件名是否合法
     *
     * @param fileName [String] 文件名
     * @return 若文件名合法，则返回文件名
     */
    private String checkNameNull(String fileName) {
        if (StringUtil.isEmpty(fileName)) {
            throw new RRException("名字居然为空？");
        }
        int dotPos = fileName.lastIndexOf(".");
        if (dotPos < 0) {
            throw new RRException("文件名不符合规范");
        }
        return fileName;
    }

    /**
     * 检查是否为图片
     *
     * @param path [String] 图片文件
     */
    public void isImage(String path) {
        String mimeType = imageFileTypeMap.getContentType(path);
        String type = mimeType.split("/")[0];
        if (!Objects.equals(Constants.IMAGE_TYPE_STRING, type)) {
            throw new CheckTypeException("该文件不为图片", 400);
        }
    }

    /**
     * 检查是否为视屏
     *
     * @param path [String] 视屏文件
     */
    public void isVideo(String path) {
        String mimeType = videoFileTypeMap.getContentType(path);
        String type = mimeType.split("/")[0];
        if (!Objects.equals(Constants.VIDEO_TYPE_STRING, type)) {
            throw new CheckTypeException("只支持 mp4 格式视屏", 400);
        }
    }

    /**
     * 检查是否为文档
     *
     * @param path [String] 文档文件
     */
    public void isText(String path) {
        String mimeType = textFileTypeMap.getContentType(path);
        String type = mimeType.split("/")[0];
        if (!Objects.equals(Constants.TEXT_TYPE_STRING, type)) {
            throw new CheckTypeException("文件不为文档类型", 400);
        }
    }
}