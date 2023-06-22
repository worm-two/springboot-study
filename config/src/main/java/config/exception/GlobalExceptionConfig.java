package config.exception;


import common.result.ServiceResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(CommonException.class)
    public ServiceResult commonException(CommonException e) {
        return ServiceResult.fail().setMsg(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    public ServiceResult paramException(MethodArgumentNotValidException e) {
        return ServiceResult.fail().setMsg("参数异常");
    }

    @ExceptionHandler(RuntimeException.class)
    public ServiceResult runtimeException(RuntimeException e) {
        return ServiceResult.fail();
    }
}
