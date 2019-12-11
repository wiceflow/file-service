package cn.sibat.file.service.exception;

/**
 * 自定义异常
 *
 * @author BF
 */
public class CheckTypeException extends RuntimeException {
    private String msg;
    private int code = 500;

    public CheckTypeException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CheckTypeException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg + " ->  " + e.getMessage();
    }

    public CheckTypeException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CheckTypeException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
