package store.idragon.product.usermanager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshimei0305
 * date  2020/12/17 7:26 下午
 * description
 * @version 1.0
 */
@Component
@Data
public class WeChatConfig {
    /**
     * 小程序Id
     */
    @Value("${weChat.mini.appId:wx2803610c21332441}")
    private String wxMiniAppId;
    /**
     * 小程序密钥
     */
    @Value("${weChat.mini.appSecret:99dcf1b3f7afec2fc736ddba412a20fb}")
    private String wxMiniAppSecret;
}
