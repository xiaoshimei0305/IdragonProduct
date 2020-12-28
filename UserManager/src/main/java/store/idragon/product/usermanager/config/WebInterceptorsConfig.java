package store.idragon.product.usermanager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.tool.rest.TokenInterceptor;
import store.idragon.tool.rest.TokenManager;

/**
 * @author xiaoshimei0305
 * date  2020/12/26 10:28 下午
 * description
 * @version 1.0
 */
@Configuration
@Slf4j
public class WebInterceptorsConfig implements WebMvcConfigurer {
    /**
     * 令牌管理
     */
    @Autowired
    private TokenManager<UserInfo> tokenManager;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor(tokenManager)).addPathPatterns("/**").excludePathPatterns("/user/wxMiniLogin");
    }
}
