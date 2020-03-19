package edu.nf.gc.web.advice;

import edu.nf.gc.service.exception.DataAccessException;
import edu.nf.gc.web.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Fu
 * @date 2019/11/14
 */
//@ControllerAdvice("edu.nf.ch05.controller")
@RestControllerAdvice("edu.nf.gc.web")
public class ControllerAspect {

    @ExceptionHandler(DataAccessException.class)
    //@ResponseBody
    public ResponseVO handleDataAccessException(DataAccessException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
