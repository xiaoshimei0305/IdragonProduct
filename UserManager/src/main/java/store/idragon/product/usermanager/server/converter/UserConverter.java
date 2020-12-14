package store.idragon.product.usermanager.server.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import store.idragon.product.usermanager.dao.domain.IdrUser;
import store.idragon.product.usermanager.dto.info.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoshimei0305
 * date  2020/12/13 1:24 上午
 * description
 * @version 1.0
 */
//@Mapper(componentModel = "spring")
@Component
public class UserConverter {
    /**
     * 转换请求结果实体
     * @param idrUser
     * @return
     */
   // @Mappings({ })
    public UserInfo toInfo(IdrUser idrUser){
        if(idrUser!=null){
            UserInfo result=new UserInfo();
            result.setUserId(idrUser.getUserId());
            result.setUserName(idrUser.getUserName());
            return result;
        }
        return null;
    }

    /**
     *  转换用户列表
     * @param idrUsers
     * @return
     */
   // @Mappings({ })
    public  List<UserInfo> toUserList(List<IdrUser> idrUsers){
        List<UserInfo> resultList=new ArrayList<>();
        if(idrUsers!=null&&idrUsers.size()>0){
            for(IdrUser item:idrUsers){
                UserInfo info=toInfo(item);
                if(info!=null){
                    resultList.add(info);
                }
            }
        }
        return resultList;
    }
}
