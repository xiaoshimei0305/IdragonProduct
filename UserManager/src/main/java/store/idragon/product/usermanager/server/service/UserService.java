package store.idragon.product.usermanager.server.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.idragon.product.usermanager.dao.IdrUserRepository;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.product.usermanager.dto.query.LoginRequest;
import store.idragon.product.usermanager.dto.query.UserQuery;
import store.idragon.product.usermanager.server.converter.UserConverter;
import store.idragon.tool.base.dto.PageDataQuery;
import store.idragon.tool.base.dto.PageResultParam;
import store.idragon.product.usermanager.dao.domain.IdrUser;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoshimei0305
 * date  2020/12/13 12:44 上午
 * description
 * @version 1.0
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private IdrUserRepository idrUserRepository;
    @Autowired
    private UserConverter userConverter;

    /**
     * 用户信息分页查询
     * @param userQuery
     * @return
     */
    public PageResultParam<UserInfo> queryUserInfo(PageDataQuery<UserQuery> userQuery) {
        List<IdrUser> dataList = idrUserRepository.findAll();
        return new PageResultParam<UserInfo>(100,userConverter.toUserList(dataList));
    }

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    public String login(LoginRequest loginRequest) {
        return loginRequest.getLoginName();
    }

}
