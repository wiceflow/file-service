package cn.sibat.file.service.util;

import java.util.Collection;

/**
 * 集合容器操作工具类
 *
 * @author BF
 */
public final class CollectionUtil {

    /**
     * 判断集合是否为空
     *
     * @param collection [Collection<?>]待判断集合
     * @return [boolean]
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    /**
     * 判断集合是否不为空
     *
     * @param collection [Collection<?>]待判断集合
     * @return [boolean]
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
