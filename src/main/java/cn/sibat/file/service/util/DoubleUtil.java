package cn.sibat.file.service.util;

/**
 * @author BF
 * @date 2019/1/4
 */
public class DoubleUtil {


    /**
     * 返回两位小数 double
     *
     * @param number 数值
     * @return 两位小数 double
     */
    public static Double changeDouble(Integer number) {
        return (double) Math.round(number * 100) / 100;
    }
}
