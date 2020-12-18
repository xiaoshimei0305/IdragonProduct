package store.idragon.product.usermanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import store.idragon.product.usermanager.util.SessionKeyHolder;
import store.idragon.tool.http.wechat.WeChatMiniAppClient;

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
     * 获取用户sessionKey 存储对象
     * @return 对象操作类
     */
    @Bean
    public SessionKeyHolder getSessionKeyHolder(){
        return new SessionKeyHolder();
    }

    /**
     * 加载单例微信客户端请求对象
     * @return 微信访问客户端
     */
    @Bean
    public WeChatMiniAppClient loadBalanced() {
        return new WeChatMiniAppClient(weChatConfig.getWxMiniAppId(),weChatConfig.getWxMiniAppSecret(),getSessionKeyHolder());
    }



}
