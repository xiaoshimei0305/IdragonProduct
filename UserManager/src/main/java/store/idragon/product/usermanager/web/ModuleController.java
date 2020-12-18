package store.idragon.product.usermanager.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.product.usermanager.dto.query.LoginRequest;
import store.idragon.product.usermanager.dto.query.UserQuery;
import store.idragon.product.usermanager.server.service.UserService;
import store.idragon.tool.base.check.ParamCheckUtils;
import store.idragon.tool.base.dto.PageDataQuery;
import store.idragon.tool.base.dto.result.PageResultParam;
import store.idragon.tool.base.dto.result.ResultInfo;
import store.idragon.tool.http.wechat.dto.WxUserInfo;

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

    /**
     * 用户列表信息查询
     * @param userQuery 用户信息查询接口
     * @return 用户列表信息
     */
    @ApiOperation(value = "查询用户列表", notes = "")
    @GetMapping(value="list")
    public ResultInfo<PageResultParam<UserInfo>> queryUserInfo(PageDataQuery<UserQuery> userQuery) {
        return ResultInfo.ok(userService.queryUserInfo(userQuery));
    }

    /**
     * 用户模拟登录操作
     * @param loginRequest 登录请求对象
     * @return 用户主键
     */
    @ApiOperation(value = "用户登录", notes = "")
    @PostMapping(value="login")
    public ResultInfo<String> login(LoginRequest loginRequest) {
        return ResultInfo.ok(userService.login(loginRequest));
    }

    /**
     * 用户微信默认登录
     * @param code 微信登录票据
     * @return 用户主键
     */
    @ApiOperation(value = "微信用户登录", notes = "")
    @PostMapping(value="wxMiniLogin")
    public ResultInfo<String> wxMiniLogin(String code) {
        ParamCheckUtils.notNull(code,"票据");
        return ResultInfo.ok(userService.wxMiniLogin(code));
    }

}
