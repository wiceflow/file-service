package cn.sibat.file.service.util;

import org.springframework.http.MediaType;

/**
 * @author iceflow
 * @date 2018/8/1
 * 常量定义
 */
public class Constants {

    /**
     * 中文
     */
    public final static String CHARSET = ";charset=UTF-8";

    /**
     * 在 springframework 中，这个变量被弃用
     */
    public final static String APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8_VALUE;

    /**
     * 是否为图片上传
     *
     * <p> 定义图片格式 png tif jpg jpeg bmp JPEG PNG JPG BMP TIF </p>
     * <p> IMAGE_PATH </p>
     */
    public final static Integer IMAGE_TYPE_INTEGER = 0;
    public final static String IMAGE_TYPE_STRING = "image";

    /**
     * 是否为文件上传
     */
    public final static Integer FILE_TYPE_INTEGER = 1;

    /**
     * 是否为文档上传
     *
     * <p> 定义文档格式 doc、docx、xls、xlxs、pdf、txt </p>
     */
    public final static Integer TEXT_TYPE_INTEGER = 2;
    public final static String TEXT_TYPE_STRING = "text";

    /**
     * 是否为视屏上传
     *
     * <p> 定义视屏格式 mp4 </p>
     */
    public final static Integer VIDEO_TYPE_INTEGER = 3;
    public final static String VIDEO_TYPE_STRING = "video";

    /**
     * 文件后缀前面的点
     */
    public final static String DOT_SEPARATOR = ".";

    /**
     * 线程池名称
     */
    public final static String IMAGE_SERVER_THREAD_POOL = "fileServerThreadPool";

}
