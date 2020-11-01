package store.idragon.product.interfacemanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaoshimei0305
 * date  2020/11/1 1:12 下午
 * description
 * @version 1.0
 */
@Api(value = "模块管理")
@RestController
@RequestMapping("module/")
public class ModuleController {
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="hello")
    public Object hello( /* 参数注解 */ @ApiParam(value = "desc of param" , required=true ) @RequestParam String name) {
        return "Hello " + name + "!";
    }
}
