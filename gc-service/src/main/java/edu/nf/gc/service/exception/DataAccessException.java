package edu.nf.gc.service.exception;

/**
 * @author wangl
 * @date 2019/11/14
 * 自定义数据访问异常
 */
public class DataAccessException extends RuntimeException{
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
