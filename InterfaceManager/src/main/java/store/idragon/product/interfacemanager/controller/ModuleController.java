package store.idragon.product.interfacemanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.idragon.product.interfacemanager.dao.IdrUserRepository;
import store.idragon.product.interfacemanager.domain.IdrUser;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private IdrUserRepository idrUserRepository;

    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="users")
    public List<IdrUser> users() {
        List<IdrUser> list = new ArrayList<IdrUser>();
        list = idrUserRepository.findAll();
        return list;
    }
}
