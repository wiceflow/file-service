package cn.sibat.file.service.multiple;




import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis-plus 自动填充功能
 *
 * @author bf
 * @create by bf on 2018-12-20 16:53
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate", new Date(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("modifyDate", new Date(System.currentTimeMillis()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate", new Date(System.currentTimeMillis()), metaObject);
    }

}
