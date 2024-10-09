package cn.edu.nbpt.lilingyi.campusmanage.exception;


import cn.edu.nbpt.lilingyi.campusmanage.pojo.Result;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.enums.ErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class GloballExceptionHandler {

    @ExceptionHandler(BizException.class)
    Result handleException(BizException e){
        e.printStackTrace();
        return Result.error("业务异常"+e.getMsg());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    Result handleIllegalArgumentBizException(BizException e){
        e.printStackTrace();
        return Result.error(ErrorCode.PARAMS_ERROR.getCode(),"参数解析失败"+e.getMsg());
    }
}
