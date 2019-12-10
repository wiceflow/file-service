package cn.sibat.file.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.IntrospectorCleanupListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * @author BF
 * @date 2019/10/28 16:34
 *
 * 内省资源清除监听器
 */
@Slf4j
@WebListener
public class IntrospectorCleanListener extends IntrospectorCleanupListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        super.contextInitialized(sce);
        log.info("加载内省资源清除监听器成功");
    }


    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("清除内存内省引用资源");
        super.contextDestroyed(event);
    }

}
