package store.idragon.product.usermanager.server.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.idragon.product.usermanager.constants.ExternalAccountEnum;
import store.idragon.product.usermanager.dao.IdrUserRepository;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.product.usermanager.dto.query.LoginRequest;
import store.idragon.product.usermanager.dto.query.UserQuery;
import store.idragon.product.usermanager.server.converter.UserConverter;
import store.idragon.tool.base.StringUtils;
import store.idragon.tool.base.dto.PageDataQuery;
import store.idragon.product.usermanager.dao.domain.IdrUser;
import store.idragon.tool.base.dto.result.PageResultParam;
import store.idragon.tool.base.exception.IDragonException;
import store.idragon.tool.http.wechat.WeChatMiniAppClient;

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
    @Autowired
    private WeChatMiniAppClient weChatMiniAppClient;

    /**
     * 用户信息分页查询
     * @param userQuery 用户信息查询接口
     * @return 用户信息
     */
    public PageResultParam<UserInfo> queryUserInfo(PageDataQuery<UserQuery> userQuery) {
        List<IdrUser> dataList = idrUserRepository.findAll();
        return new PageResultParam<UserInfo>(100,userConverter.toUserList(dataList));
    }

    /**
     * 用户登录
     * @param loginRequest 登录请求对象
     * @return 登录用户Id
     */
    public String login(LoginRequest loginRequest) {
        return loginRequest.getLoginName();
    }

    /**
     * 根据微信小程序票据完成用户登录
     * @param code 微信返回用户票据
     * @return 用户编号
     */
    public String wxMiniLogin(String  code) {
        String openId=weChatMiniAppClient.getLoginInfo(code).getOpenId();
        String userId=queryUserByOpenId(openId,ExternalAccountEnum.WX_MINI);
        if(StringUtils.isBlank(userId)){
            createUserByOpenId(openId,ExternalAccountEnum.WX_MINI);
            userId= queryUserByOpenId(openId,ExternalAccountEnum.WX_MINI);
            if(StringUtils.isBlank(userId)){
                throw new IDragonException();
            }
        }
        return userId;
    }


    /**
     * 通过openId 获取系统内用户唯一标示
     * @param openId 用户帐号
     * @param type 帐号类型 【建议与数据库设计字段名称一致】
     * @return 用户唯一ID
     */
    public String queryUserByOpenId(String openId, ExternalAccountEnum type){
        IdrUser info = idrUserRepository.queryOneByFieldValue(openId);
        if(info!=null){
            return info.getUserId();
        }
        return null;
    }

    /**
     * 通过外部帐号创建用户名称
     * @param openId 外部帐号唯一标示
     * @param type 外部帐号类型
     */

    public void createUserByOpenId(String openId, ExternalAccountEnum type){
         idrUserRepository.createrUserByExctenalAccount(openId,openId);
    }

}
