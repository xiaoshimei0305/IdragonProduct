package store.idragon.product.usermanager.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import store.idragon.tool.base.dto.result.ResultInfo;

/**
 * @author xiaoshimei0305
 * date  2020/12/21 8:02 下午
 * description
 * @version 1.0
 */
@ControllerAdvice(basePackages = "store.idragon.product.usermanager.web")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo<String> jsonErrorHandler(Exception exception){
        return ResultInfo.fail(exception);
    }
}
