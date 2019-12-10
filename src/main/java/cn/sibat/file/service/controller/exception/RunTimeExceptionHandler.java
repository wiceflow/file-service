package cn.sibat.file.service.controller.exception;


import cn.sibat.file.service.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author BF
 */
@Slf4j
@RestControllerAdvice
public class RunTimeExceptionHandler {
    /**
     * 处理自定义运行时异常
     */
    @ExceptionHandler(RRException.class)
    public AjaxResult handleRRException(RRException e) {
        log.error("异常统一管理处打印异常信息：" + e.getMessage());
        if (e.getCode() != 500) {
            return AjaxResult.customResponse(e.getCode(), e.getMessage(), null);
        }
        return AjaxResult.errorResponse(e.getMsg());
    }

    /**
     * 处理自定义运行时异常
     */
    @ExceptionHandler(CheckTypeException.class)
    public AjaxResult handleCheckTypeException(CheckTypeException e) {
        log.error("类型异常：" + e.getMessage());
        if (e.getCode() != 500) {
            return AjaxResult.customResponse(e.getCode(), e.getMessage(), null);
        }
        return AjaxResult.errorResponse(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        // 控制台打印错误信息
        e.printStackTrace();
        return AjaxResult.errorResponse(e.getMessage());
    }

}
