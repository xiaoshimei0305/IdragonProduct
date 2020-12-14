package store.idragon.product.usermanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.product.usermanager.dto.query.LoginRequest;
import store.idragon.product.usermanager.dto.query.UserQuery;
import store.idragon.product.usermanager.server.service.UserService;
import store.idragon.tool.base.dto.PageDataQuery;
import store.idragon.tool.base.dto.PageResultParam;
import store.idragon.tool.base.dto.ResultInfo;

/**
 * @author xiaoshimei0305
 * date  2020/11/1 1:12 下午
 * description
 * @version 1.0
 */
@Api(value = "用户管理")
@RestController
@RequestMapping("user/")
public class ModuleController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户列表", notes = "")
    @GetMapping(value="list")
    public ResultInfo<PageResultParam<UserInfo>> queryUserInfo(PageDataQuery<UserQuery> userQuery) {
        return ResultInfo.ok(userService.queryUserInfo(userQuery));
    }
    @ApiOperation(value = "用户登录", notes = "")
    @PostMapping(value="login")
    public ResultInfo<String> login(LoginRequest loginRequest) {
        return ResultInfo.ok(userService.login(loginRequest));
    }

}
