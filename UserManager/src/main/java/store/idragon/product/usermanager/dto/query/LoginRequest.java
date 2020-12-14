package store.idragon.product.usermanager.dto.query;

import lombok.Data;

/**
 * @author xiaoshimei0305
 * date  2020/12/13 12:51 上午
 * description 用户登录请求
 * @version 1.0
 */
@Data
public class LoginRequest {
    /**
     * 用户登录名
     */
    private String loginName;
    /**
     * 用户登录密码
     */
    private String password;
}
