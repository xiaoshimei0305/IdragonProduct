package store.idragon.product.usermanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.product.usermanager.util.StringHolder;
import store.idragon.product.usermanager.util.UserInfoHolder;
import store.idragon.tool.http.wechat.WeChatMiniAppClient;
import store.idragon.tool.rest.TokenManager;

/**
 * @author xiaoshimei0305
 * date  2020/12/17 7:23 下午
 * <p>统一单例配置页面</p>
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"store.idragon.product.usermanager"})
public class ComponentConfig {
    @Autowired
    private WeChatConfig weChatConfig;

    /**
     * 加载单例微信客户端请求对象
     * @return 微信访问客户端
     */
    @Bean
    public WeChatMiniAppClient loadWeChatMiniAppClient() {
        return new WeChatMiniAppClient(weChatConfig.getWxMiniAppId(),weChatConfig.getWxMiniAppSecret(),loadStringHolder());
    }

    /**
     * 获取用户管理
     * @return  用户管理
     */
    @Bean
    public TokenManager<UserInfo> loadTokenManager() {
        return new TokenManager<>(loadUserHolder());
    }
    /**
     * 获取用户管理
     * @return  用户管理
     */
    @Bean
    public UserInfoHolder loadUserHolder() {
        return new UserInfoHolder();
    }
    /**
     * 获取用户管理
     * @return  用户管理
     */
    @Bean
    public StringHolder loadStringHolder() {
        return new StringHolder();
    }

}
