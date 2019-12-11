package cn.sibat.file.service.util;

import cn.sibat.file.service.exception.RRException;
import cn.sibat.file.service.factory.ExecutorFactory;
import cn.sibat.file.service.vo.FileVO;

import java.util.concurrent.*;

/**
 * 并发线程执行辅助类
 *
 * @author BF
 * @date 2018/8/2
 */
public class ExecuteServiceUtil {

    /**
     * 保证了始终只有一个线程池操作
     */
    private static ExecutorService executorService = ExecutorFactory.THREAD_POOL.getExecutor();

    /**
     * 执行一个无返回值的线程任务
     *
     * @param task [Runnable] 无返回的线程任务
     */
    public static void execute(Runnable task) {
        executorService.execute(task);
    }

    /**
     * 执行有返回值的线程任务
     * 返回项目路径
     * 超时100秒
     *
     * @param task [Callable] 有返回的线程任务
     * @return FileVO
     */
    public static FileVO execute(Callable<FileVO> task) {
        Future<FileVO> result = executorService.submit(task);
        try {
            return result.get(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("上传失败 :" + e.getMessage(), 409);
        }
    }
}
